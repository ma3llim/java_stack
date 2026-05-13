package com.sameer.quiz.controller;

import com.sameer.quiz.models.QuestionWrapper;
import com.sameer.quiz.services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions, @RequestParam String title){
        return quizServices.createQuiz(category, noOfQuestions, title);
    }

    @GetMapping("/getquiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId){
        return quizServices.getQuizQuestions(quizId);
    }
}
