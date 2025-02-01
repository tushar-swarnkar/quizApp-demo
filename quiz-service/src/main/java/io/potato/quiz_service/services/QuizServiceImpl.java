package io.potato.quiz_service.services;

import io.potato.quiz_service.entities.Quiz;
import io.potato.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> quizList = quizzes.stream()
                .map(quiz -> {
                    quiz.setQuestionList(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
        return quizList;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz NOT FOUND!"));
        quiz.setQuestionList(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
