package com.ken.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice用于为所有Controller配置全局的Model
 * 在Controller中可以使用方法参数Model model获取这个全局的Model
 */
@ControllerAdvice
public class GlobalConfig {

    @ModelAttribute(value = "info")
    public Map<String, String> userInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "罗贯中");
        map.put("gender", "男");
        return map;
    }
}
