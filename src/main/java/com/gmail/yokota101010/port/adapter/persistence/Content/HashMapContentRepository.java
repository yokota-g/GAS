package com.gmail.yokota101010.port.adapter.persistence.Content;

import java.util.HashMap;

import com.gmail.yokota101010.domain.model.Content.Content;
import com.gmail.yokota101010.domain.model.Content.ContentRepository;

public class HashMapContentRepository implements ContentRepository {
    public static HashMap<String,Content> contents = new HashMap<>();

    @Override
    public long count(){
        return contents.size();
    }

    @Override
    public void save(String id,Content content) {
        contents.put(content.id,content);
    }

    @Override
    public Content contentNamed(String name) {
        for(Content content : contents.values()){
            if(content.name.equals(name)){
                return content;
            }
        }
        return null;
    }

    @Override
    public void reset() {
        contents.clear();
    }

    @Override
    public Content contentIdIs(String contentId) {
        return contents.get(contentId);
    }
}
