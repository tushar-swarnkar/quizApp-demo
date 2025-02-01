package io.potato.quiz_service.repository;

import io.potato.quiz_service.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
