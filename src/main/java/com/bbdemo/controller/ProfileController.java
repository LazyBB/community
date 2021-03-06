package com.bbdemo.controller;

import com.bbdemo.dto.PaginationDTO;
import com.bbdemo.model.User;
import com.bbdemo.service.NoticeService;
import com.bbdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "3") Integer size) {
        User user =(User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }
        if (action.equals("questions")) {
            PaginationDTO pagination = questionService.List(user.getId(), page, size);
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问题");
            model.addAttribute("pagination",pagination);
        }
        if (action.equals("replies")) {
            Long unreadCount = noticeService.unreadCount(user.getId());
            PaginationDTO pagination = noticeService.List(user.getId(),page,size);
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
            model.addAttribute("unreadCount", unreadCount);
            model.addAttribute("pagination",pagination);
        }

        return "profile";
    }
}
