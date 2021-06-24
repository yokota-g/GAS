package com.gmail.yokota101010.domain.model.Content;

import static org.junit.Assert.assertEquals;

import com.gmail.yokota101010.port.adapter.persistence.Content.HashMapContentRepository;

import org.junit.Before;
import org.junit.Test;

public class ContentTest {
    ContentRepository contents;
    Content content;

    @Before
    public void setUp() throws Exception {
        contents = new HashMapContentRepository();
    }

    @Test
    public void Kindle本のカテゴリーを正しく取得できる() {
        content = new Content("Java", 2000, ContentType.KindleBook);
        assertEquals( content.type, ContentType.KindleBook);
    }

    @Test
    public void 紙書籍のカテゴリーを正しく取得できる() {
        content = new Content("SQL", 1500, ContentType.PaperBook);
        assertEquals( content.type, ContentType.PaperBook);
    }

    @Test
    public void コンテンツに疑問を追加できる() {
        content = new Content("SQL", 1500, ContentType.PaperBook);
        content.addQuestion("insertの方法は？","",QuestionStatus.Open);
        content.addQuestion("deleteの方法は？","",QuestionStatus.Open);

        assertEquals( content.questions.size(), 2);
    }
}
