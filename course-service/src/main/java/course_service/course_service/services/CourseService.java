package course_service.course_service.services;

import course_service.course_service.dtos.CourseDetailDTO;
import course_service.course_service.repository.courseRepository.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepositoryImpl courseRepository;

    @Autowired
    public CourseService(CourseRepositoryImpl courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDetailDTO> findAll(){

    }
}
