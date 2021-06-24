package com.gmail.yokota101010.domain.model.Content;

import java.util.HashMap;
import java.util.UUID;

public class Content {
    public String id;
    public String name;
    public int price;
    public ContentType type;
    public HashMap<String,Question> questions;

    public Content(String name, int price, ContentType type){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.type = type;
        questions = new HashMap<>();
    }

    public void addQuestion(String question, String answer, QuestionStatus st){
        Question q = new Question(question, answer, st);
        questions.put(q.id, q);
    }
}
