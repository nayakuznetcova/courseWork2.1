package com.example.coursWork21.service;
import com.example.coursWork21.storage.Question;
import java.util.Collection;

public interface QuestionService {
    boolean add(String question, String answer);
    boolean remove(String question, String answer);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
