package com.ken.controller;

import com.ken.properties.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    /**
     * 配合构造方法可以注入application.properties里面的book配置
     */
    final Book book;

    public BookController(Book book) {
        this.book = book;
    }

    /**
     * https://127.0.0.1:8088/chapter02/book
     * @return
     */
    @GetMapping("/book")
    public String book() {
        return book.toString();
    }
}
