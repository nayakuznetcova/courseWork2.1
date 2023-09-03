package com.example.coursWork21.controller;

import com.example.coursWork21.service.JavaQuestionService;
import com.example.coursWork21.service.QuestionService;
import com.example.coursWork21.storage.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String question, @RequestParam String answer){
        return "result add: " + javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String question, @RequestParam String answer){
        return "result remove: " + javaQuestionService.remove(question, answer);
    }

    @GetMapping
    public String getAll(){
        return "result: " + javaQuestionService.getAll();
    }
}
