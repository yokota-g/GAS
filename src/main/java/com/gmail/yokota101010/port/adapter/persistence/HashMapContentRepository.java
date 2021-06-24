package com.gmail.yokota101010.port.adapter.persistence;

import java.util.HashMap;
import com.gmail.yokota101010.domain.model.Content;
import com.gmail.yokota101010.domain.model.ContentRepository;

public class HashMapContentRepository extends ContentRepository {
    public HashMap<String,Content> contents = new HashMap<>();

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
}
