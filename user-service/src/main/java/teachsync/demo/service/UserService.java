package teachsync.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teachsync.demo.dto.CreateUpdateUserDTO;
import teachsync.demo.dto.UserToFindDTO;
import teachsync.demo.entities.User;
import teachsync.demo.exceptions.CreateUpdateEntityException;
import teachsync.demo.exceptions.NotFoundException;
import teachsync.demo.mapper.UserMapper;
import teachsync.demo.repositories.UserRepository;
import teachsync.demo.utils.PasswordHash;

import java.util.List;
import java.util.UUID;

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

    @Transactional
    public void createUser(CreateUpdateUserDTO userToCreate) throws CreateUpdateEntityException {
        try {
            User user = new User();
            PasswordHash hash = new PasswordHash();
            if (userToCreate.getPassword() == null || userToCreate.getPassword().isBlank()) {
                throw new CreateUpdateEntityException("Password must not be blank");
            }
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

    @Transactional
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
            if(userToUpdate.getUsername() != null) {
                user.setUsername(userToUpdate.getUsername());
            }
            userRepository.updateUser(user);
        }catch (CreateUpdateEntityException e){
            throw new CreateUpdateEntityException(e.getMessage());
        }catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    @Transactional
    public void deleteUser(UUID id) throws NotFoundException {
        try{
            User user = userRepository.getUser(id);
            userRepository.deleteUser(user.getId());
        }catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
    }
}
