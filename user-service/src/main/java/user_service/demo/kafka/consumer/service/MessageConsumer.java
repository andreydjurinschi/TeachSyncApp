package user_service.demo.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import user_service.demo.entities.User;
import user_service.demo.exceptions.NotFoundException;
import user_service.demo.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseRequest;
import user_service.demo.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseResponse;
import user_service.demo.repositories.UserRepository;

@Service
public class MessageConsumer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final UserRepository userRepository;

    public MessageConsumer(KafkaTemplate<String, Object> kafkaTemplate, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "test-topic", groupId = "user-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "teacher-check-request", groupId = "user-group-id")
    public void listenTeacherCheckRequest(TeacherAssignToCourseRequest request) throws NotFoundException {
        TeacherAssignToCourseResponse response = new TeacherAssignToCourseResponse();
        response.setTeacherId(request.getTeacherId());
        response.setCourseId(request.getCourseId());
        User user = userRepository.getUser(request.getTeacherId());
        if (user == null) {
            throw new NotFoundException("Пользователь " + request.getTeacherId() + " не найден");
        }
        if(user.getRole().equals("TEACHER") == false) {
            response.setTeacher(false);
            response.setExistsInSystem(false);
            response.setMessage("Пользователь не является учителем");
        }
        kafkaTemplate.send("teacher-check-request", response);
    }
}
