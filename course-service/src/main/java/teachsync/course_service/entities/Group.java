package teachsync.course_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate created_at;

    @ManyToMany(mappedBy = "groups")
    private Set<Course> courses = new HashSet<>();

    public Group(String name, LocalDate created_at) {
        this.name = name;
        this.created_at = created_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Group() {
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
