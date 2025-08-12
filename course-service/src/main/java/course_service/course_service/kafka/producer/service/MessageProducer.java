package course_service.course_service.kafka.producer.service;

import course_service.course_service.entities.Course;
import course_service.course_service.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseRequest;
import course_service.course_service.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseResponse;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final Map<String, CompletableFuture<TeacherAssignToCourseResponse>> futures = new ConcurrentHashMap<>();

    @Autowired
    public MessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public TeacherAssignToCourseResponse sendAndWait(UUID userId, UUID courseId) throws Exception {
        String correlationId = UUID.randomUUID().toString();

        CompletableFuture<TeacherAssignToCourseResponse> future = new CompletableFuture<>();
        futures.put(correlationId, future);

        TeacherAssignToCourseRequest request =
                new TeacherAssignToCourseRequest(userId, courseId, correlationId);

        kafkaTemplate.send("teacher-check-request", request);

        TeacherAssignToCourseResponse response = future.get(10, TimeUnit.SECONDS);
        futures.remove(correlationId);
        return response;
    }

    @KafkaListener(topics = "teacher-check-response", groupId = "course-group-id")
    public void handleResponse(TeacherAssignToCourseResponse response) {
        CompletableFuture<TeacherAssignToCourseResponse> future = futures.get(response.getCorrelationId());
        if (future != null) {
            future.complete(response);
        }
    }
}
