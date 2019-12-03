package com.ken.controller.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @ControllerAdvice的另一种用法,请求参数预处理.
 * 为controller的实体参数指定页面传值的前缀
 */
@ControllerAdvice
public class BookControllerAdvice {

    @InitBinder("book")
    public void initBook(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("book.");
    }

    @InitBinder("author")
    public void initAuthor(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("author.");
    }
}
