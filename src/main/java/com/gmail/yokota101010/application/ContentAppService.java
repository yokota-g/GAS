package com.gmail.yokota101010.application;

import com.gmail.yokota101010.domain.model.Content.Content;
import com.gmail.yokota101010.domain.model.Content.ContentRepository;
import com.gmail.yokota101010.port.adapter.persistence.Content.HashMapContentRepository;

public class ContentAppService {
    ContentRepository contents = new HashMapContentRepository();

    public void reviseQuestion(String contentId, String questionId, String revisedQuestion){
        Content content = contents.contentIdIs(contentId);
        content.reviseQuestion(questionId, revisedQuestion);
    } 
}
