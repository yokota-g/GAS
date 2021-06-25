package com.gmail.yokota101010.domain.model.Content;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.gmail.yokota101010.port.adapter.persistence.Content.HashMapContentRepository;

import org.junit.Before;
import org.junit.Test;

public class ContentTest {
    ContentRepository contents;
    Content content,content2,content3;

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

    @Test
    public void コンテンツの疑問を更新できる() {
        content = new Content("SQL", 1500, ContentType.PaperBook);
        content.addQuestion("insertの方法は？","",QuestionStatus.Open);
        contents.save(content.id,content);

        content2 = contents.contentNamed("SQL");
        HashMap<String,Question> qs2 = content2.allQuestions();
        Iterator<String> iterator2 = qs2.keySet().iterator();
        content2.reviseQuestion(iterator2.next(), "insertの詳しい方法は？");

        content3 = contents.contentNamed("SQL");
        HashMap<String,Question> qs3 = content3.allQuestions();
        Iterator<String> iterator3 = qs3.keySet().iterator();
        Question q3 = qs3.get(iterator3.next());
        assertEquals( q3.question, "insertの詳しい方法は？");
    }
}
