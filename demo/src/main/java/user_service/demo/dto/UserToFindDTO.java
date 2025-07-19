package user_service.demo.dto;

import jakarta.persistence.Column;
import user_service.demo.entities.UserRole;

import java.util.UUID;

public class UserToFindDTO {
    private UUID id;
    private String username;
    private String full_name;
    private String email;
    private UserRole role;

    public UserToFindDTO() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserToFindDTO(UUID id, String username, String full_name, String email, UserRole role) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
