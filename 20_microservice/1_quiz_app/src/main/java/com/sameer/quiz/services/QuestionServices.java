package com.sameer.quiz.services;

import com.sameer.quiz.dao.QuestionDao;
import com.sameer.quiz.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServices {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }

    public String deleteQuestion(Integer questionId) {
        questionDao.deleteById(questionId);
        return "Question Deleted";
    }
}
