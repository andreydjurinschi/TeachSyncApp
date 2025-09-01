package teachsync.demo.mapper;

import org.springframework.stereotype.Component;
import teachsync.demo.dto.UserToFindDTO;
import teachsync.demo.entities.User;

@Component
public class UserMapper {

    public UserToFindDTO userToFindDTO(User user) {
        return new UserToFindDTO(
                user.getId(),
                user.getUsername(),
                user.getFull_name(),
                user.getEmail(),
                user.getRole()
        );
    }


}
