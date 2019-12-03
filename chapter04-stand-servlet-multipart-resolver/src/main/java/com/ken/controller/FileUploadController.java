package com.ken.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

@Slf4j
@RestController
public class FileUploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Value("${upload-location}")
    private String uploadPath;

    /**
     * 单文件上传
     * @param uploadFile
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        log.info("上传文件保存的路径: {}", uploadPath);
        // 格式化日期,将当前日期格式化位xxxx/xx/xx的格式
        String format = sdf.format(new Date());
        // 上传文件的路径为{uploadPath}/{year}/{month}/{date}
        File folder = new File(uploadPath + "/" + format + "/");
        // 如果目录不存在创建目录
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + oldName.substring(oldName.lastIndexOf("."));
        // 返回一个图片URL,如http://domain|ip:port//uploadFile/2019/12/01/{uuid}.jpg
        try {
            uploadFile.transferTo(new File(folder, newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + "/" + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }

    /**
     * 多文件上传
     * @param uploadFiles
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/uploads")
    public String uploads(MultipartFile[] uploadFiles, HttpServletRequest request) throws Exception {
        if (uploadFiles != null && uploadFiles.length > 0) {
            List<String> pathList = new ArrayList<>();
            String format = sdf.format(new Date());
            File folder = new File(uploadPath + "/" + format + "/");
            if (!folder.isDirectory()) {
                folder.mkdirs();
            }
            for (MultipartFile uploadFile: uploadFiles) {
                String oldName = uploadFile.getOriginalFilename();
                String fileName = UUID.randomUUID().toString().replaceAll("-", "") + oldName.substring(oldName.lastIndexOf("."));
                uploadFile.transferTo(new File(folder, fileName));
                String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + "/" + fileName;
                pathList.add(filePath);
            }

            StringBuffer result = new StringBuffer("");
            pathList.stream().forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    result.append(s + "<br>");
                }
            });
            return result.toString();
        }
        return "上传失败!";
    }

    /**
     * 映射图片
     * @param year
     * @param month
     * @param date
     * @param guid
     * @param suffix
     * @param response
     * @throws Exception
     */
    @GetMapping("/uploadFile/{year}/{month}/{date}/{guid}.{suffix}")
    public void uploadFile(@PathVariable String year, @PathVariable String month, @PathVariable String date, @PathVariable String guid, @PathVariable String suffix, HttpServletResponse response) throws Exception {
        log.info("year: {}\tmonth: {}\tdate: {}\tguid: {}\tsuffix: {}", year, month, date, guid, suffix);
        OutputStream out = response.getOutputStream();
        FileInputStream fis = new FileInputStream(uploadPath + "/" + year + "/" + month + "/" + date + "/" + guid + "." + suffix);
        byte[] buf = new byte[1024];
        int data = 0;
        while ((data = fis.read(buf, 0, buf.length - 1)) != -1) {
            out.write(buf, 0, buf.length - 1);
        }
        out.flush();
    }
}
