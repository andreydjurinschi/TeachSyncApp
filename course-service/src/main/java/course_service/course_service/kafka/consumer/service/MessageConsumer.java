package course_service.course_service.kafka.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import course_service.course_service.kafka.common_events.course_user_events.assign_to_course.TeacherAssignToCourseResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "teacher-check-response", groupId = "course-group-id")
    public void teacherCheckResponse(TeacherAssignToCourseResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(response));
    }
}
