package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.Book;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-4
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
public class BookManagerTest extends BaseTestCase {

    private BookManager bookManager;

    @Resource
    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Test
    public void testSave() {
        Book book = new Book();
        book.setName("book2");
        book.setContent("content2");

        bookManager.save(book);
    }

    @Test
    public void testUpdate() {
        Book book = new Book();
        book.setId(1L);
        book.setName("第一本书");
        book.setContent("content1");

        bookManager.save(book);
    }
}
