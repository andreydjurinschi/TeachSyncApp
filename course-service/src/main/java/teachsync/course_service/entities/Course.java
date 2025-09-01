package teachsync.course_service.entities;

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
@Table(name = "courses")
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
    @ManyToMany
    @JoinTable(name = "course_topics",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private Set<Topic> topics;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public Course() {
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
