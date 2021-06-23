package com.gmail.yokota101010.domain.model;

public interface ContentRepository {
    public long count();
    public void save(String name,Content content);
    public Content contentNamed(String name);
}
