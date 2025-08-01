package course_service.course_service.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Сущность курса
 * id - уникальный идентификатор
 * name - название курса
 * description - описание курса
 * teacherId - идентификатор учителя курса
 */

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private UUID teacherId;

    @ManyToMany
    @JoinTable (name = "group_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>();
}
