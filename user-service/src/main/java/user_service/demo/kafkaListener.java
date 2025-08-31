package user_service.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(kafkaListener.class);

    @KafkaListener(topics = "course-user", groupId = "user-service-group")
    public void listen(String message){
        logger.info("Message consumed: {}", message);
    }
}
