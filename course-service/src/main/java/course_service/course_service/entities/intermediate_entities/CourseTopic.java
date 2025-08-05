package course_service.course_service.entities.intermediate_entities;

import course_service.course_service.Ids.CourseTopicId;
import course_service.course_service.entities.Course;
import course_service.course_service.entities.Topic;
import jakarta.persistence.*;

@Entity
@Table(name = "course_topics")
public class CourseTopic {

    @EmbeddedId
    private CourseTopicId courseTopicId;

    @ManyToOne
    @MapsId("courseId")
    private Course course;

    @ManyToOne
    @MapsId("topicId")
    private Topic topic;

    public CourseTopic() {
    }

    public CourseTopic(CourseTopicId courseTopicId, Course course, Topic topic) {
        this.courseTopicId = courseTopicId;
        this.course = course;
        this.topic = topic;
    }

    public CourseTopicId getCourseTopicId() {
        return courseTopicId;
    }

    public void setCourseTopicId(CourseTopicId courseTopicId) {
        this.courseTopicId = courseTopicId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
