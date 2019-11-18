package com.ken.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String author;
    private String name;
    protected Float price;
    private Date publicationDate;
}
