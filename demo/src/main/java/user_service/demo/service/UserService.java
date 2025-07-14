package user_service.demo.service;

import org.springframework.stereotype.Service;
import user_service.demo.dto.CreateUpdateUserDTO;
import user_service.demo.dto.UserToFindDTO;
import user_service.demo.entities.User;
import user_service.demo.exceptions.NotFoundException;
import user_service.demo.mapper.UserMapper;
import user_service.demo.repositories.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserToFindDTO> getAllUsers() {
        List<User> allUsers = userRepository.getUsers();
        return allUsers.stream().map(
                userMapper::userToFindDTO
        ).toList();
    }

    public UserToFindDTO getUserById(UUID id) throws NotFoundException {
        try{
            User user = userRepository.getUser(id);
            return userMapper.userToFindDTO(user);
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public void createUser(CreateUpdateUserDTO userToCreate) throws NotFoundException {
        try {
            userRepository.createUser();
        }
    }
}
