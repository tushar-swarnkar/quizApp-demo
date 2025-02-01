package io.potato.question_service.services;

import io.potato.question_service.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    Question get(Long id);

    List<Question> getAll();

    List<Question> getQuestionsOfQuiz(Long quizId);

}
