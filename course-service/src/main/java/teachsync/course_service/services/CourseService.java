package teachsync.course_service.services;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teachsync.course_service.dtos.courseDTO.CourseBaseDTO;
import teachsync.course_service.dtos.courseDTO.CourseCreateUpdateDTO;
import teachsync.course_service.dtos.courseDTO.CourseDetailDTO;
import teachsync.course_service.entities.Course;
import teachsync.course_service.mappers.CourseMapper;
import teachsync.course_service.repository.courseRepository.CourseRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepositoryImpl courseRepository;
    private final CourseMapper courseMapper;

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
