package course_service.course_service.kafka.common_events.course_user_events.assign_to_course;

import java.util.UUID;

public class TeacherAssignToCourseResponse {
    private UUID courseId;
    private UUID teacherId;
    private boolean isTeacher;
    private boolean existsInSystem;
    private String message;

    public TeacherAssignToCourseResponse(UUID courseId, UUID teacherId, boolean isTeacher, boolean existsInSystem, String message) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.isTeacher = isTeacher;
        this.existsInSystem = existsInSystem;
        this.message = message;
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
