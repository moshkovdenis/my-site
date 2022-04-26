package ru.denis.photosite.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.denis.photosite.entites.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select new ru.denis.photosite.entites.User(u.id, u.name, u.age, u.email) from users u where u.name = :name")
    User findUserByName(@Param("name") String name);

    @Query(value = "select new ru.denis.photosite.entites.User(u.id, u.name, u.age, u.email) from users u")
    List<User> findAllUsers(Sort sort);

    @Query(value = "select new ru.denis.photosite.entites.User(u.id, u.name, u.age, u.email)" +
            " from users u where u.id = :id")
    User findUserById(@Param("id") UUID id);
}
