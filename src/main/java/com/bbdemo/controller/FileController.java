package com.bbdemo.controller;

import com.bbdemo.dto.FileDTO;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.exception.CustomizeException;
import com.bbdemo.provider.AliyunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class FileController {
    @Autowired
    AliyunProvider aliyunProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("editormd-image-file");
        String url = "";
        if (file!=null) {
           url = aliyunProvider.upload(file.getInputStream(), file.getContentType(), file.getOriginalFilename());
        }else {
            throw new CustomizeException(CustomizeErrorCode.IMAGE_UPLOAD_FALSE);
        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl(url);
        return fileDTO;
    }
}
