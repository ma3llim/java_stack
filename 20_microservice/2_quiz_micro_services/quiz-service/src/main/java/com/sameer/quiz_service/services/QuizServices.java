package com.sameer.quiz_service.services;

import com.sameer.quiz_service.dao.QuizDao;
import com.sameer.quiz_service.feign.QuizInterface;
import com.sameer.quiz_service.models.QuestionWrapper;
import com.sameer.quiz_service.models.Quiz;
import com.sameer.quiz_service.models.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServices {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, noOfQuestions).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Created Quiz Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizDao.findById(quizId).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> responses) {
      ResponseEntity<Integer> scrore = quizInterface.getScore(responses);
      return scrore;
    }
}
