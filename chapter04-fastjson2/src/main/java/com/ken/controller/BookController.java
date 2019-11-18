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
        book.setAuthor("曹雪芹");
        book.setName("红楼梦");
        book.setPrice(50.55f);
        book.setPublicationDate(new Date());
        return book;
    }
}
