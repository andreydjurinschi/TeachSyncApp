package user_service.demo.kafka.common_events.course_user_events.assign_to_course;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TeacherAssignToCourseRequest {
    private UUID teacherId;
    private UUID courseId;
    private String correlationId;

    @JsonCreator
    public TeacherAssignToCourseRequest(@JsonProperty("teacherId") UUID teacherId, @JsonProperty("courseId") UUID courseId,@JsonProperty("correlationId") String correlationId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }
}

