package com.gmail.yokota101010.application;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.gmail.yokota101010.domain.model.ContentRepository;
import com.gmail.yokota101010.domain.model.Content;
import com.gmail.yokota101010.port.adapter.persistence.HashMapContentRepository;

public class RegisterNewContentTest {
    ContentRepository contents;
    Content content1,content2,content3;

    @Before
    public void setUp() throws Exception {
        contents = new HashMapContentRepository();
        content1 = new Content(contents.getID(),"Java",2000);
        content2 = new Content(contents.getID(),"SQL",1500);
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
