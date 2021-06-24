package com.gmail.yokota101010.domain.model.Content;

public class Content {
    public String id;
    public String name;
    public int price;
    public ContentType type;

    public Content(String id, String name, int price, ContentType type){
        this.id =id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
