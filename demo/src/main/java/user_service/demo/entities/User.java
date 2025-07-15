package user_service.demo.entities;

import jakarta.persistence.*;
import user_service.demo.utils.PasswordHash;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue
    private UUID Id;

    @Column(unique = true, nullable = false)
    private String username;

    private String hashedPassword;

    @Column(unique = true, nullable = false)
    private String full_name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "user_role")
    private UserRole role;

    public User() {
    }

    public User(UUID id, String username, String hashedPassword, String full_name, String email, UserRole role) {
        Id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.full_name = full_name;
        this.email = email;
        this.role = role;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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
