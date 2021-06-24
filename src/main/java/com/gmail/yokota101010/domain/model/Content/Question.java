package com.gmail.yokota101010.domain.model.Content;

import java.util.UUID;

public class Question {
    public String id;
    public String question;
    public String answer;
    public QuestionStatus st = QuestionStatus.Open;

    public Question(String question,String answer,QuestionStatus st){
        this.id = UUID.randomUUID().toString();;
        this.question = question;
        this.answer = answer;
        this.st = st;
    }
}
