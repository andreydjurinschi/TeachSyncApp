package user_service.demo.kafka.common_events.course_user_events.assign_to_course;

import java.util.UUID;

public class TeacherAssignToCourseResponse {
    private UUID courseId;
    private UUID teacherId;
    private boolean isTeacher;
    private boolean existsInSystem;
    private String message;
    private String correlationId;

    public TeacherAssignToCourseResponse(UUID courseId, UUID teacherId, boolean isTeacher, boolean existsInSystem, String message, String correlationId) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.isTeacher = isTeacher;
        this.existsInSystem = existsInSystem;
        this.message = message;
        this.correlationId = correlationId;
    }

    public TeacherAssignToCourseResponse() {
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

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isExistsInSystem() {
        return existsInSystem;
    }

    public void setExistsInSystem(boolean existsInSystem) {
        this.existsInSystem = existsInSystem;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
