package user_service.demo.mapper;

import org.springframework.stereotype.Component;
import user_service.demo.dto.UserToFindDTO;
import user_service.demo.entities.User;

@Component
public class UserMapper {

    public UserToFindDTO userToFindDTO(User user) {
        return new UserToFindDTO(
                user.getUsername(),
                user.getFull_name(),
                user.getEmail(),
                user.getRole()
        );
    }


}
