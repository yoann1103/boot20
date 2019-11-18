package com.ken.properties;

import lombok.Data;

import java.util.List;

@Data
//@Component
//@ConfigurationProperties(prefix = "my")
public class User {
    private String name;
    private String address;
    private List<String> favorites;
}
