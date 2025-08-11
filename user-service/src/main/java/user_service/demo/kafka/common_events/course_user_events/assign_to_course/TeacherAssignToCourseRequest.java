package user_service.demo.kafka.common_events.course_user_events.assign_to_course;

import java.util.UUID;

public class TeacherAssignToCourseRequest {
    private UUID courseId;
    private UUID teacherId;

    public TeacherAssignToCourseRequest() {
    }

    public TeacherAssignToCourseRequest(UUID courseId, UUID teacherId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
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
