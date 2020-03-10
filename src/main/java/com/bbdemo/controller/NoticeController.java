package com.bbdemo.controller;

import com.bbdemo.dto.NoticeDTO;
import com.bbdemo.enums.NoticeEnum;
import com.bbdemo.model.User;
import com.bbdemo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;


@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice/{id}")
    public String profile(HttpServletRequest request, @PathVariable(name = "id") long id){
        User user =(User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }
        NoticeDTO read = noticeService.read(id);

        if (NoticeEnum.REPLY_COMMENT.getType() == read.getType()
                || NoticeEnum.REPLY_QUESTION.getType() == read.getType()) {
            return "redirect:/question/" + read.getOuterid();
        } else {
            return "redirect:/";
        }
    }
}
