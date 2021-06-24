package com.gmail.yokota101010.domain.model.Content;

public abstract class ContentRepository {
    public abstract long count();
    public abstract void save(String id,Content content);
    public abstract Content contentNamed(String name);
}
