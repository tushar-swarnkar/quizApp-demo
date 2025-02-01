package io.potato.question_service.controllers;

import io.potato.question_service.entities.Question;
import io.potato.question_service.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping("/all")
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable("id") Long id) {
        return questionService.get(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable("quizId") Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

}
