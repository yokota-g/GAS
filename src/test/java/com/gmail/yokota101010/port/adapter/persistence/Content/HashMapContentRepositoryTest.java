package com.gmail.yokota101010.port.adapter.persistence.Content;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.gmail.yokota101010.domain.model.Content.Content;
import com.gmail.yokota101010.domain.model.Content.ContentRepository;
import com.gmail.yokota101010.domain.model.Content.ContentType;

public class HashMapContentRepositoryTest {
    ContentRepository contents = new HashMapContentRepository();
    Content content1,content2,content3;

    @Before
    public void setUp() throws Exception {
        contents.reset();
        content1 = new Content("Java", 2000, ContentType.KindleBook);
        content2 = new Content("SQL", 1500, ContentType.PaperBook);
    }

    @Test
    public void 初期状態では登録なし() {
        assertEquals( contents.count(), (long)0 );
    }

    @Test
    public void 一件登録すると一件ある() {
        contents.save(content1.id, content1);
        assertEquals( contents.count(), (long)1 );
    }

    @Test
    public void 二件登録して一件目を取り出せる() {
        contents.save(content1.id, content1);
        contents.save(content2.id, content2);
        assertEquals( contents.count(), (long)2 );
        content3 = contents.contentNamed("Java");
        assertEquals( content3.price, (long)2000 );
    }
}
