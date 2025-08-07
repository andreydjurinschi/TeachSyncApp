package course_service.course_service.controllers;

import java.util.List;
import course_service.course_service.dtos.CourseDetailDTO;
import course_service.course_service.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public void getCourses(){
        System.out.println("getCourses");
    }

    @GetMapping("/allCourses")
    public ResponseEntity<List<CourseDetailDTO>> getAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }
}
