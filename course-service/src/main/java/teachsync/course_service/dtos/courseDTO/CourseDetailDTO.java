package teachsync.course_service.dtos.courseDTO;

import java.util.Set;

public class CourseDetailDTO {

    private String name;
    private String description;
    private Set<String> topicNames;

    public CourseDetailDTO(String name, String description, Set<String> topicNames) {
        this.name = name;
        this.description = description;
        this.topicNames = topicNames;
    }

    public CourseDetailDTO(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Set<String> getTopicNames() {
        return topicNames;
    }

    public void setTopicNames(Set<String> topicNames) {
        this.topicNames = topicNames;
    }
}
