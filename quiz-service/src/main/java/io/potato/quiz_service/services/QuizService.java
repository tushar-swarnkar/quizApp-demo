package io.potato.quiz_service.services;

import io.potato.quiz_service.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz create(Quiz quiz);

    List<Quiz> getAll();

    Quiz get(Long id);
}
