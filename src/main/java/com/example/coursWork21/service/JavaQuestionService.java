package com.example.coursWork21.service;

import com.example.coursWork21.exceptions.FewQuestionsException;
import com.example.coursWork21.repository.JavaQuestionRepository;
import com.example.coursWork21.storage.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return javaQuestionRepository.add(newQuestion);
    }

    @Override
    public boolean remove(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return javaQuestionRepository.remove(newQuestion);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        try {
            int numberTicket = random.nextInt(javaQuestionRepository.getAll().size() - 1);
            int current = 0;
            for (Question q : javaQuestionRepository.getAll()) {
                if (current == numberTicket) {
                    return q;
                }
                current++;
            }
        } catch (Exception e) {
            throw new FewQuestionsException();
        }
        throw new FewQuestionsException();
    }
}