package ru.denis.photosite.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.denis.photosite.entites.User;
import ru.denis.photosite.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        User existingUser = userRepository.findUserByName(user.getName());
        if (existingUser != null) {
            return new User(true);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers(Sort.by("id"));
    }

    public User findUserById(UUID id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            return new User(false);
        }
        return user;
    }
}
