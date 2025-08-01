package course_service.course_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate created_at;

    @ManyToMany
    @JoinTable (name = "group_courses",
                joinColumns = @JoinColumn(name = "group_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();
}
