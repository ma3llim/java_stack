package com.sameer.quiz.services;

import com.sameer.quiz.dao.QuestionDao;
import com.sameer.quiz.dao.QuizDao;
import com.sameer.quiz.models.Question;
import com.sameer.quiz.models.QuestionWrapper;
import com.sameer.quiz.models.Quiz;
import com.sameer.quiz.models.quizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, noOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Created Quiz Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
         Optional<Quiz> quizs = quizDao.findById(quizId);
         List<Question> questionsFromDB = quizs.get().getQuestions();
         List<QuestionWrapper> questionWrappers = new ArrayList<>();
         for(Question q : questionsFromDB){
             QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4() );
             questionWrappers.add(questionWrapper);
         }

         return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<quizResponse> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (quizResponse response: responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
