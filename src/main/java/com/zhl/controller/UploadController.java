package com.zhl.controller;

import com.zhl.pojo.Result;
import com.zhl.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}",image.getOriginalFilename());
//        调用阿里云工具类方法进行文件上传
        String url= aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问url:{}",url);
        return Result.success(url);
    }
}
