package com.gmail.yokota101010.domain.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.gmail.yokota101010.domain.model.Content.Content;
import com.gmail.yokota101010.domain.model.Content.ContentRepository;
import com.gmail.yokota101010.domain.model.Content.ContentType;
import com.gmail.yokota101010.port.adapter.persistence.HashMapContentRepository;

public class ContentTest {
    ContentRepository contents;
    Content content1,content2;

    @Before
    public void setUp() throws Exception {
        contents = new HashMapContentRepository();
    }

    @Test
    public void Kindle本のカテゴリーを正しく取得できる() {
        content1 = new Content(contents.getID(), "Java", 2000, ContentType.KindleBook);
        assertEquals( content1.type, ContentType.KindleBook);
    }

    @Test
    public void 紙書籍のカテゴリーを正しく取得できる() {
        content2 = new Content(contents.getID(), "SQL", 1500, ContentType.PaperBook);
        assertEquals( content2.type, ContentType.PaperBook);
    }
}
