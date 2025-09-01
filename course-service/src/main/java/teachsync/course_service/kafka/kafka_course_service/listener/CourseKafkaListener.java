package teachsync.course_service.kafka.kafka_course_service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import teachsync.responses.CheckIfUserExistsResponse;

@Service
public class CourseKafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(CourseKafkaListener.class);
    @KafkaListener(topics = "check-user-response", groupId = "course-service-group")
    public void listenToUserExistsResponse(CheckIfUserExistsResponse response){
        if(response.isExists() && response.isTeacher()){
            logger.info("Successfully! user exists!!! you can add him to course");
        }else if(!response.isTeacher()){
            logger.warn("User does is not a teacher");
        }else{
            logger.warn("User does not exist");
        }
    }
}
