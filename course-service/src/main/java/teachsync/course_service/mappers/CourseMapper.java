package teachsync.course_service.mappers;

import org.springframework.stereotype.Component;
import teachsync.course_service.dtos.courseDTO.CourseBaseDTO;
import teachsync.course_service.dtos.courseDTO.CourseDetailDTO;
import teachsync.course_service.entities.Course;
import teachsync.course_service.entities.Topic;

import java.util.HashSet;
import java.util.Set;

@Component
public class CourseMapper {


    public Course toEntity(CourseDetailDTO courseDetailDTO){
        return new Course(courseDetailDTO.getName(), courseDetailDTO.getDescription());
    }

    public CourseDetailDTO toDTO(Course course){
        return new CourseDetailDTO(course.getName(), course.getDescription(), extractNamesFromTopics(course.getTopics()));
    }

    public CourseBaseDTO toBaseDTO(Course course){
        return new CourseBaseDTO(course.getName(), course.getDescription());
    }

    private Set<String> extractNamesFromTopics(Set<Topic> topics ){
        Set<String> names = new HashSet<>();
        for (var el : topics){
            names.add(el.getName());
        }
        return names;
    }
}
