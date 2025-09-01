package teachsync.demo.kafka.user_kafka_service;

import org.apache.kafka.common.errors.RecordDeserializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
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
        try {
            userRepository.getUser(event.getUserId());
            exists = true;
        } catch (NotFoundException e) {
            logger.warn("User not found: {}", event.getUserId());
        }
        CheckIfUserExistsResponse response = new CheckIfUserExistsResponse(event.getUserId(), exists);
        logger.info("Sending response: {} to topic check-user-response", response);
        kafkaUserExistsResponse.send("check-user-response", response);
    }
}
