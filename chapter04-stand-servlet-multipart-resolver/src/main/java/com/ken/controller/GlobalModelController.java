package com.ken.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@RestController
public class GlobalModelController {

    @GetMapping("/hello")
    public void hello(Model model, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Map<String, Object> modelMap = model.asMap();
        PrintWriter out = response.getWriter();
        for (Map.Entry<String, Object> entry : modelMap.entrySet()) {
            out.println(entry.getKey() + "--->" + entry.getValue());
        }
        out.flush();
    }
}
