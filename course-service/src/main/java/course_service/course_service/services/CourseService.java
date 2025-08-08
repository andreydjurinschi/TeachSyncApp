package course_service.course_service.services;

import course_service.course_service.dtos.CourseBaseDTO;
import course_service.course_service.dtos.CourseDetailDTO;
import course_service.course_service.entities.Course;
import course_service.course_service.mappers.CourseMapper;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepositoryImpl courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepositoryImpl courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseBaseDTO> findAll(){
        List<Course> courses = courseRepository.getAllCourses();
        List<CourseBaseDTO> dto = new ArrayList<>();
        for(var el : courses){
            dto.add(courseMapper.toBaseDTO(el));
        }
        return dto;
    }

    public CourseDetailDTO findCourse(UUID id){
        Course course = courseRepository.getCourseById(id);
        if(course == null){
            throw new EntityNotFoundException("Данный курс отсутствует в системе");
        }
        return courseMapper.toDTO(course);
    }
}
