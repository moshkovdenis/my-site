package ru.denis.photosite.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denis.photosite.entites.User;
import ru.denis.photosite.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UsersController {
    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        if (newUser.isExist()) {
            return new ResponseEntity<>("User already exist" , HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<?> deleteUser(@RequestParam(value = "id", required = true) Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/get-user-by-id")
    public ResponseEntity<?> getUserById(@RequestParam(value = "id", required = true)UUID id) {
        User user = userService.findUserById(id);
        if (!user.isExist()) {
            return new ResponseEntity<>("User not found" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
