package course_service.course_service.kafka.kafkaCourseService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Course kafka producer class for sending messages in other services
 */
@Service
public class CourseKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(CourseKafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public CourseKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTestMessage(String message){
        logger.info("Message sent : {}", message);
        kafkaTemplate.send("course-user", message);
    }
}
