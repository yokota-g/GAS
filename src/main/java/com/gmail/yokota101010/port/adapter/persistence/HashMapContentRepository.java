package com.gmail.yokota101010.port.adapter.persistence;

import java.util.HashMap;
import com.gmail.yokota101010.domain.model.Content;
import com.gmail.yokota101010.domain.model.ContentRepository;

public class HashMapContentRepository implements ContentRepository {
    public HashMap<String,Content> contents = new HashMap<>();

    @Override
    public long count(){
        return contents.size();
    }

    @Override
    public void save(String name,Content content) {
        contents.put(content.name,content);
    }

    @Override
    public Content contentNamed(String name) {
        return contents.get(name);
    }
}
