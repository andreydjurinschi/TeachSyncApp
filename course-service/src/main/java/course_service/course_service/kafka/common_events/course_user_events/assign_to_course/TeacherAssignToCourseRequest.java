package course_service.course_service.kafka.common_events.course_user_events.assign_to_course;

import java.util.UUID;

public class TeacherAssignToCourseRequest {
    private UUID teacherId;
    private UUID courseId;

    public TeacherAssignToCourseRequest(UUID teacherId, UUID courseId) {
        this.teacherId = teacherId;
        this.courseId = courseId;
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
