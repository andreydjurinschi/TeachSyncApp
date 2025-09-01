package teachsync.course_service.dtos.courseDTO;

import jakarta.validation.constraints.*;

public class CourseCreateUpdateDTO {

    @NotBlank(message = "Название курса обязательно для заполнения")
    @Size(min = 3, max = 255, message = "Название курса должно быть от 4 до 255 символов")
    private String name;
    private String description;

    public CourseCreateUpdateDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public @NotBlank(message = "Название курса обязательно для заполнения") @Size(min = 3, max = 255, message = "Название курса должно быть от 4 до 255 символов") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Название курса обязательно для заполнения") @Size(min = 3, max = 255, message = "Название курса должно быть от 4 до 255 символов") String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
