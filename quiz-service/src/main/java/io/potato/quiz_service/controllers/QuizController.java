package io.potato.quiz_service.controllers;

import io.potato.quiz_service.entities.Quiz;
import io.potato.quiz_service.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping()
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.create(quiz);
    }

    @GetMapping("/all")
    public List<Quiz> getAll() {
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable("id") Long id) {
        return quizService.get(id);
    }

}
