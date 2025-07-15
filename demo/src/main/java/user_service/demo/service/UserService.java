package user_service.demo.service;

import org.springframework.stereotype.Service;
import user_service.demo.dto.CreateUpdateUserDTO;
import user_service.demo.dto.UserToFindDTO;
import user_service.demo.entities.User;
import user_service.demo.exceptions.CreateUpdateEntityException;
import user_service.demo.exceptions.NotFoundException;
import user_service.demo.mapper.UserMapper;
import user_service.demo.repositories.UserRepository;
import user_service.demo.utils.PasswordHash;

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

    public void createUser(CreateUpdateUserDTO userToCreate) throws CreateUpdateEntityException {
        try {
            User user = new User();
            PasswordHash hash = new PasswordHash();
            user.setUsername(userToCreate.getUsername());
            user.setHashedPassword(hash.hash(userToCreate.getPassword()));
            user.setFull_name(userToCreate.getFull_name());
            user.setEmail(userToCreate.getEmail());
            user.setRole(userToCreate.getRole());
            userRepository.createUser(user);
        }catch (CreateUpdateEntityException e){
            throw new CreateUpdateEntityException(e.getMessage());
        }
    }

    public void updateUser(UUID id, CreateUpdateUserDTO userToUpdate) throws CreateUpdateEntityException, NotFoundException {
        try{
            User user = userRepository.getUser(id);
            if (userToUpdate.getFull_name() != null) {
                user.setFull_name(userToUpdate.getFull_name());
            }
            if (userToUpdate.getEmail() != null) {
                user.setEmail(userToUpdate.getEmail());
            }

            if (userToUpdate.getRole() != null) {
                user.setRole(userToUpdate.getRole());
            }

        }
    }
}
