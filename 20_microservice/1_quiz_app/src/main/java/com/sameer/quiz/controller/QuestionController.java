package com.sameer.quiz.controller;

import com.sameer.quiz.models.Question;
import com.sameer.quiz.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    QuestionServices questionServices;

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionServices.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionServices.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionServices.addQuestion(question);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer questionId){
        return questionServices.deleteQuestion(questionId);
    }
}
