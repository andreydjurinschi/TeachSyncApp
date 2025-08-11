package course_service.course_service.kafka.producer.service;

import course_service.course_service.entities.Course;
import course_service.course_service.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseRequest;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final CourseRepositoryImpl courseRepository;

    @Autowired
    public MessageProducer(KafkaTemplate<String, Object> kafkaTemplate, CourseRepositoryImpl courseRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.courseRepository = courseRepository;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendMessageToAssignTeacher(UUID userId, UUID courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new EntityNotFoundException("Курс не был найжен");
        }
        TeacherAssignToCourseRequest teacherAssignToCourseRequest = new TeacherAssignToCourseRequest(userId, courseId);
        kafkaTemplate.send("teacher-check-request", teacherAssignToCourseRequest);
    }
}
