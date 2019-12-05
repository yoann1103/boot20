package com.ken.componet;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 自定义Error数据
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes= super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("customMessage", "出错了");
        errorAttributes.remove("error");
        return errorAttributes;
    }
}
