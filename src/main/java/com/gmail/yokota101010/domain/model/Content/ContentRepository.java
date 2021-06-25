package com.gmail.yokota101010.domain.model.Content;

public interface ContentRepository {
    public long count();
    public void save(String id,Content content);
    public Content contentIdIs(String contentId);
    public Content contentNamed(String name);
    public void reset();
}
