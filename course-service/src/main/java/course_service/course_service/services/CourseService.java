package course_service.course_service.services;

import course_service.course_service.dtos.courseDTO.CourseBaseDTO;
import course_service.course_service.dtos.courseDTO.CourseCreateUpdateDTO;
import course_service.course_service.dtos.courseDTO.CourseDetailDTO;
import course_service.course_service.entities.Course;
import course_service.course_service.mappers.CourseMapper;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Transactional
    public void createCourse(CourseCreateUpdateDTO dto){
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        courseRepository.createCourse(course);
    }

    @Transactional
    public void updateCourse(UUID id, CourseCreateUpdateDTO dto){
        Course course = courseRepository.getCourseById(id);
        if(course == null){
            throw new EntityNotFoundException("Данный курс отсутствует в системе");
        }
        if(dto.getName() != null){
            course.setName(dto.getName());
        }
        if(dto.getDescription() != null && !dto.getDescription().isEmpty()){
            course.setDescription(dto.getDescription());
        }
        courseRepository.updateCourse(course);
    }

    @Transactional
    public void deleteCourse(UUID id){
        Course course = courseRepository.getCourseById(id);
        if(course == null){
            throw new EntityNotFoundException("Данный курс отсутствует в системе");
        }
        courseRepository.deleteCourse(id);
    }
}
