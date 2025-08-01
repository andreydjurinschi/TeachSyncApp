package course_service.course_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String name;
}
