package user_service.demo.dto;

import user_service.demo.entities.UserRole;

public class CreateUpdateUserDTO {
    private String username;
    private String full_name;
    private String email;
    private UserRole role;


    public CreateUpdateUserDTO() {
    }

    public CreateUpdateUserDTO(String username, String full_name, String email, UserRole role) {
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
