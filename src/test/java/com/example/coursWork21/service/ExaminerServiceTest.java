package com.example.coursWork21.service;

import com.example.coursWork21.storage.Question;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminerServiceTest {
    private final QuestionService questionService = Mockito.mock(QuestionService.class);
    private final ExaminerService examinerService = new ExaminerServiceImpl(questionService);

    @Test
    public void getRandomQuestionsTest() {
        Question question1 = new Question("q", "a");
        Question question2 = new Question("que", "answ");
        Question question3 = new Question("question", "answer");
        Collection<Question> expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);
        Mockito.when(questionService.getAll()).thenReturn(expected);
        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(question1)
                .thenReturn(question2)
                .thenReturn(question3);
        Collection<Question> collection = examinerService.getRandomQuestions(3);
        assertEquals(expected, collection);

    }
}
