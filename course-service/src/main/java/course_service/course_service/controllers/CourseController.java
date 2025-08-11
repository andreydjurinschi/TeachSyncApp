package course_service.course_service.controllers;

import java.util.List;
import java.util.UUID;

import course_service.course_service.dtos.courseDTO.CourseBaseDTO;
import course_service.course_service.dtos.courseDTO.CourseCreateUpdateDTO;
import course_service.course_service.dtos.courseDTO.CourseDetailDTO;
import course_service.course_service.kafka.producer.service.MessageProducer;
import course_service.course_service.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final MessageProducer messageProducer;

    @Autowired
    public CourseController(CourseService courseService, MessageProducer messageProducer) {
        this.courseService = courseService;
        this.messageProducer = messageProducer;
    }

    public void getCourses(){
        System.out.println("getCourses");
    }

    @GetMapping("/allCourses")
    public ResponseEntity<List<CourseBaseDTO>> getAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDTO> findCourse(@PathVariable UUID id){
        return ResponseEntity.ok(courseService.findCourse(id));
    }

    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody @Valid CourseCreateUpdateDTO dto){
        courseService.createCourse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Курс успешно создан: \n " + dto.getName() + " \n" + dto.getDescription());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable UUID id, @RequestBody @Valid CourseCreateUpdateDTO dto){
        courseService.updateCourse(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body("Курс успешно обновлен: \n " + dto.getName() + " \n" + dto.getDescription());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable UUID id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Курс успешно удален");
    }

    @PostMapping("/test")
    public ResponseEntity<String> sendTestMessage(@RequestParam String message){
        messageProducer.sendMessage("test-topic", message);
        return ResponseEntity.ok().body("Message sent: " + message);
    }
}
