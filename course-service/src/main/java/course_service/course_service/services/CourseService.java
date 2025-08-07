package course_service.course_service.services;

import course_service.course_service.dtos.CourseDetailDTO;
import course_service.course_service.entities.Course;
import course_service.course_service.mappers.CourseMapper;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepositoryImpl courseRepository;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepositoryImpl courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDetailDTO> findAll(){
        List<Course> courses = courseRepository.getAllCourses();
        List<CourseDetailDTO> dto = new ArrayList<>();
        for(var el : courses){
            dto.add(courseMapper.toDTO(el));
        }
        return dto;
    }
}
