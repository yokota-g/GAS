package com.gmail.yokota101010.application;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.gmail.yokota101010.domain.model.Content.Content;
import com.gmail.yokota101010.domain.model.Content.ContentRepository;
import com.gmail.yokota101010.domain.model.Content.ContentType;
import com.gmail.yokota101010.domain.model.Content.QuestionStatus;
import com.gmail.yokota101010.port.adapter.persistence.Content.HashMapContentRepository;

public class ContentAppServiceTest {
    ContentRepository contents = new HashMapContentRepository();
    Content content;
    
    @Before
    public void setUp() throws Exception {
        contents.reset() ;
        content = new Content("Java", 2000, ContentType.KindleBook);
        content.addQuestion("newの方法は？","",QuestionStatus.Open);
        contents.save(content.id, content);
    }

    @Test
    public void コンテンツの疑問を更新できる() {
        String contentId = content.id;
        String questionId = content.allQuestions().keySet().iterator().next();

        ContentAppService app = new ContentAppService();
        app.reviseQuestion(contentId, questionId, "printの方法は？");

        assertEquals(content.allQuestions().values().iterator().next().question, "printの方法は？");
    }
}
