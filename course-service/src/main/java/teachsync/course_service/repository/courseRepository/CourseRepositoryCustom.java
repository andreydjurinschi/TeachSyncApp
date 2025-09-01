package teachsync.course_service.repository.courseRepository;

import java.util.UUID;

public interface CourseRepositoryCustom {
    void changeTeacherForCourse(UUID courseId, UUID teacherId);
    void removeTeacherFromCourse(UUID courseId);
    void addTopic(UUID courseId, UUID topicId);
    void removeTopic(UUID courseId, UUID topicId);
}
