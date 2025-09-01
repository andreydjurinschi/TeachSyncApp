package teachsync.course_service.kafka.kafka_course_service.producer;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import teachsync.requests.CheckIfUserExistsEvent;

/**
 * Course kafka producer class for sending messages in other services
 */
@Service
public class CourseKafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(CourseKafkaProducer.class);
    private final KafkaTemplate<String, CheckIfUserExistsEvent> checkIfUserExistsEventKafkaTemplate;

    public CourseKafkaProducer(KafkaTemplate<String, CheckIfUserExistsEvent> kafkaTemplate, KafkaTemplate<String, CheckIfUserExistsEvent> checkIfUserExistsEventKafkaTemplate) {
        this.checkIfUserExistsEventKafkaTemplate = checkIfUserExistsEventKafkaTemplate;
    }
    // user must be a teacher
    public void checkIfUserExistsEvent(CheckIfUserExistsEvent event){
        checkIfUserExistsEventKafkaTemplate.send("course-user", event);
    }
}
