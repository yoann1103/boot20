package com.ken.controller;

import com.ken.domain.Author;
import com.ken.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    /**
     * 以如下方式访问这个controller
     * http://127.0.0.1:8080/book?book.name=三国演义&book.author=罗贯中&author.name=罗贯中&age=300
     * book参数和author参数的属性都将正确赋值
     * 因为Book类中有属性name,Author类中也有属性name
     * 为了避免混淆可以在@ControllerAdvice中使用@InitBinder规定好,参见BookControllerAdvice类
     * @param book
     * @param author
     * @return
     */
    @GetMapping("/book")
    public String book(@ModelAttribute("book") Book book, @ModelAttribute("author") Author author) {
        return book.toString() + "--->" + author.toString();
    }
}
