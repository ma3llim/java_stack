package com.sameer.quiz.dao;
import com.sameer.quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int noOfQuestions);

    List<Question> findByCategory(String category);
}
