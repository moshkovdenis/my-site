package ru.denis.photosite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.photosite.entites.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
