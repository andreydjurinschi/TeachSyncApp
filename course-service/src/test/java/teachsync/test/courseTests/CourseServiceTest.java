package teachsync.test.courseTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teachsync.course_service.dtos.courseDTO.CourseBaseDTO;
import teachsync.course_service.dtos.courseDTO.CourseCreateUpdateDTO;
import teachsync.course_service.dtos.courseDTO.CourseDetailDTO;
import teachsync.course_service.entities.Course;
import teachsync.course_service.mappers.CourseMapper;
import teachsync.course_service.repository.courseRepository.CourseRepositoryImpl;
import teachsync.course_service.services.CourseService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepositoryImpl courseRepository;

    @Mock
    private CourseMapper courseMapper;


    @Test
    void updateCurse(){

        UUID id = UUID.randomUUID();
        Course courseToUpdate = new Course("OldName", "OldDescription");
        courseToUpdate.setId(id);

        CourseCreateUpdateDTO dtoToUpdate = new CourseCreateUpdateDTO(
                "NewName",
                "NewDescription"
        );

        when(courseRepository.getCourseById(courseToUpdate.getId())).thenReturn(courseToUpdate);
        doNothing().when(courseRepository).updateCourse(courseToUpdate);

        courseService.updateCourse(courseToUpdate.getId(), dtoToUpdate);

        assertEquals("NewName", courseToUpdate.getName());
        assertEquals("NewDescription", courseToUpdate.getDescription());
    }

    @Test
    void createCourse(){
        UUID id = UUID.randomUUID();
        CourseCreateUpdateDTO courseCreateUpdateDTO = new CourseCreateUpdateDTO(
                "Test", "Test"
        );
        Course course = new Course();
        course.setId(id);
        course.setName(courseCreateUpdateDTO.getName());
        course.setDescription(courseCreateUpdateDTO.getDescription());

        doNothing().when(courseRepository).createCourse(any(Course.class));
        courseService.createCourse(courseCreateUpdateDTO);




    }

    @Test
    void getCourseTest(){
        Course course1 = new Course();
        course1.setId(UUID.randomUUID());
        course1.setName("Test");
        course1.setDescription("Test description");

        when(courseRepository.getCourseById(course1.getId())).thenReturn(course1);
        when(courseMapper.toDTO(course1))
                .thenReturn(new CourseDetailDTO(course1.getName(), course1.getDescription(), Set.of("First topic", "Second topic")));

        CourseDetailDTO courseDetailDTO = courseService.findCourse(course1.getId());
        assertNotNull(courseDetailDTO);
        assertEquals("Test", courseDetailDTO.getName());
        assertEquals("Test description", courseDetailDTO.getDescription());

        verify(courseRepository, times(1)).getCourseById(course1.getId());
        verify(courseMapper, times(1)).toDTO(course1);

    }

    @Test
    void testGetAllCourses() {
        Course course1 = new Course();
        course1.setId(UUID.randomUUID());
        course1.setName("Math");
        course1.setDescription("Desc");

        Course course2 = new Course();
        course2.setId(UUID.randomUUID());
        course2.setName("Rus");
        course2.setDescription("Desc");

        when(courseRepository.getAllCourses()).thenReturn(List.of(course1, course2));

        when(courseMapper.toBaseDTO(course1))
                .thenReturn(new CourseBaseDTO(course1.getName(), course1.getDescription()));
        when(courseMapper.toBaseDTO(course2))
                .thenReturn(new CourseBaseDTO(course2.getName(), course2.getDescription()));

        List<CourseBaseDTO> dtos = courseService.findAll();

        assertNotNull(dtos);
        assertEquals(2, dtos.size());
        assertEquals("Math", dtos.get(0).getName());
        assertEquals("Rus", dtos.get(1).getName());

        verify(courseRepository, times(1)).getAllCourses();
        verify(courseMapper, times(1)).toBaseDTO(course1);
        verify(courseMapper, times(1)).toBaseDTO(course2);

    }

}

