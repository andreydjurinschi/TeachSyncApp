package course_service.course_service.controllers;

import java.util.List;
import java.util.UUID;

import course_service.course_service.dtos.CourseBaseDTO;
import course_service.course_service.dtos.CourseDetailDTO;
import course_service.course_service.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<CourseBaseDTO>> getAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDTO> findCourse(@PathVariable String id){
        UUID uuid;
        try{
            uuid = UUID.fromString(id);
        }catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неверный формат идентификатора");
        }
        return ResponseEntity.ok(courseService.findCourse(uuid));
    }
}
