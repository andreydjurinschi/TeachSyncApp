package user_service.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.demo.dto.CreateUpdateUserDTO;
import user_service.demo.dto.UserToFindDTO;
import user_service.demo.exceptions.CreateUpdateEntityException;
import user_service.demo.exceptions.NotFoundException;
import user_service.demo.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserToFindDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserById(@RequestParam UUID id) {
        try{
            UserToFindDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUpdateUserDTO userToCreate) {
         try{
         userService.createUser(userToCreate);
         return ResponseEntity.status(HttpStatus.CREATED).body(userToCreate);
         }catch (CreateUpdateEntityException e){
             return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
         }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id,@RequestBody @Valid CreateUpdateUserDTO userToUpdate) {
        try{
            userService.updateUser(id, userToUpdate);
            return ResponseEntity.ok(userToUpdate);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
