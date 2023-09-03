package com.example.coursWork21.service;
import com.example.coursWork21.exceptions.FewQuestionsException;
import com.example.coursWork21.repository.JavaQuestionRepository;
import com.example.coursWork21.storage.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    private QuestionService javaQuestionService = new JavaQuestionService(javaQuestionRepository);

    @ParameterizedTest
    @CsvSource({"que, answ", "question, answer", "q, a"})
    public void addTest(String que, String answ){
        boolean result = javaQuestionService.add(que, answ);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"q, a", "que, answ", "question, answer"})
    public void removeTest(String question, String answer){
        javaQuestionService.add(question, answer);
        boolean result = javaQuestionService.remove(question, answer);
        assertTrue(result);
    }


    @Test
    public void getAllTest(){
        javaQuestionService.add("q", "a");
        javaQuestionService.add("que", "answ");
        javaQuestionService.add("question", "answer");
        Collection<Question> result = javaQuestionService.getAll();
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question("q", "a"));
        expected.add(new Question("que", "answ"));
        expected.add(new Question("question", "answer"));
        assertEquals(expected, result);
    }

    @Test
    public void getRandomQuestionTest(){
        javaQuestionService.add("q", "a");
        javaQuestionService.add("que", "answ");
        javaQuestionService.add("question", "answer");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        Collection<Question> questions = javaQuestionService.getAll();
        assertTrue(questions.contains(randomQuestion));
    }

    @Test
    public void getRandomQuestionExceptionTest(){
        assertThrows(FewQuestionsException.class, () -> javaQuestionService.getRandomQuestion());
    }
}
