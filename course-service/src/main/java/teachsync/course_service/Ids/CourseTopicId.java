package teachsync.course_service.Ids;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CourseTopicId implements Serializable {

    private UUID courseId;
    private UUID topicId;

    public CourseTopicId() {
    }

    public CourseTopicId(UUID courseId, UUID topicId) {
        this.courseId = courseId;
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTopicId that = (CourseTopicId) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(topicId, that.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, topicId);
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public UUID gettopicId() {
        return topicId;
    }

    public void settopicId(UUID topicId) {
        this.topicId = topicId;
    }
}
