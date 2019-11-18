package com.ken.controller;

import com.ken.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BookController {

    @ResponseBody
    @GetMapping
    public Book book() {
        Book book = new Book();
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice(30.5f);
        book.setPublicationDate(new Date());
        return book;
    }
}
