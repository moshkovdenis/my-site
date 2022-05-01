package ru.denis.photosite.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.denis.photosite.entites.Client;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Client, Long> {

    @Query(value = "select new ru.denis.photosite.entites.Client(c.id, c.name, c.age, c.email) from client c where c.name = :name")
    Client findUserByName(@Param("name") String name);

    @Query(value = "select new ru.denis.photosite.entites.Client(c.id, c.name, c.age, c.email)" +
            " from client c where c.id = :id")
    Client findUserById(@Param("id") UUID id);
}
