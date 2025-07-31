package course_service.course_service.repository;

import java.util.UUID;

public interface CourseRepositoryCustom {
    void changeTeacherForCourse(UUID courseId, UUID teacherId);
}
