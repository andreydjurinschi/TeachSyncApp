package teachsync.course_service.entities.intermediate_entities;


import jakarta.persistence.*;
import teachsync.course_service.Ids.CourseTopicId;
import teachsync.course_service.entities.Course;
import teachsync.course_service.entities.Topic;

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
