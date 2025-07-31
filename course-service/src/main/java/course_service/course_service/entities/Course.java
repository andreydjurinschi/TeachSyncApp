package course_service.course_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
