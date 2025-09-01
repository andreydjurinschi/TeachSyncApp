package teachsync.course_service.entities.intermediate_entities;



import jakarta.persistence.*;
import teachsync.course_service.Ids.GroupCourseId;
import teachsync.course_service.entities.Course;
import teachsync.course_service.entities.Group;

@Entity
public class GroupCourse {

    @EmbeddedId
    private GroupCourseId groupCourseId;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_d")
    private Group group;
}
