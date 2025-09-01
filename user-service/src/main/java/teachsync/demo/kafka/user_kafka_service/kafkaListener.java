package teachsync.demo.kafka.user_kafka_service;

import jakarta.persistence.EntityNotFoundException;
import org.apache.kafka.common.errors.RecordDeserializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import teachsync.demo.entities.User;
import teachsync.demo.entities.UserRole;
import teachsync.demo.exceptions.NotFoundException;
import teachsync.requests.CheckIfUserExistsEvent;
import teachsync.responses.CheckIfUserExistsResponse;
import teachsync.demo.repositories.UserRepository;

@Service
public class kafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(kafkaListener.class);
    private final UserRepository userRepository;
    private final KafkaTemplate<String, CheckIfUserExistsResponse> kafkaUserExistsResponse;

    public kafkaListener(UserRepository userRepository, KafkaTemplate<String, CheckIfUserExistsResponse> kafkaUserExistsResponse) {
        this.userRepository = userRepository;
        this.kafkaUserExistsResponse = kafkaUserExistsResponse;
    }

    @KafkaListener(topics = "course-user", groupId = "user-service-group")
    public void checkIfUserExists(CheckIfUserExistsEvent event) {
        logger.info("Message consumed, try to find: {}", event.getUserId());
        boolean exists = false;
        boolean isTeacher = false;
        try {
            User user = userRepository.getUser(event.getUserId());
            if(user.getRole() != UserRole.TEACHER){
                throw new NotFoundException("Teacher not found");
            }
            isTeacher = true;
            exists = true;
        } catch (NotFoundException e) {
            logger.warn("User not found: {}", event.getUserId() + e.getMessage());
        }
        CheckIfUserExistsResponse response = new CheckIfUserExistsResponse(event.getUserId(), exists, isTeacher);
        logger.info("Sending response: {} to topic check-user-response", response);
        kafkaUserExistsResponse.send("check-user-response", response);
    }
}
