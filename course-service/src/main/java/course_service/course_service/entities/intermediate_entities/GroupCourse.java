package course_service.course_service.entities.intermediate_entities;

import course_service.course_service.Ids.GroupCourseId;
import course_service.course_service.entities.Course;
import course_service.course_service.entities.Group;
import jakarta.persistence.*;

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
