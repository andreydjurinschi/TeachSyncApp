package user_service.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import user_service.demo.entities.UserRole;

public class CreateUpdateUserDTO {

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    private String username;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 15, message = "Password must be between 6 and 15 characters")
    private String password;

    @NotBlank(message = "Full name must not be blank")
    @Size(min = 3, max = 25, message = "Full name must be between 3 and 25 characters")
    private String full_name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email format")
    @Size(max = 50, message = "Email must be less than 50 characters")
    private String email;

    @NotNull(message = "User role must not be null")
    private UserRole role;


    public CreateUpdateUserDTO() {
    }

    public CreateUpdateUserDTO(String username, String password ,String full_name, String email, UserRole role) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
