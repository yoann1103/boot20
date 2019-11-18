package com.ken.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String name;
    private String author;
    protected Float price;
    private Date publicationDate;
}
