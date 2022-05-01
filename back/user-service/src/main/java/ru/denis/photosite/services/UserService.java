package ru.denis.photosite.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.denis.photosite.entites.Client;
import ru.denis.photosite.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public void createUser(Client client) {
        userRepository.save(client);
    }

    public void deleteUser(Long userId) {
         userRepository.deleteById(userId);
    }

    public List<Client> getAllUsers() {
        return userRepository.findAll(Sort.by("id"));
    }

    public Client findUserById(UUID id) {
        Client client = userRepository.findUserById(id);
        if (client == null) {
            return new Client(false);
        }
        return client;
    }
}
