package com.bbdemo.controller;

import com.bbdemo.dto.CommentUserDTO;
import com.bbdemo.dto.QuestionDTO;
import com.bbdemo.enums.CommentTypeEnum;
import com.bbdemo.service.CommentService;
import com.bbdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") long id, Model model
    ) {
        QuestionDTO question = questionService.findById(id);
        List<CommentUserDTO> comments =commentService.listByTargetId(id, CommentTypeEnum.QUESTION.getType());
        questionService.incView(id);
        model.addAttribute("question",question);
        model.addAttribute("comments",comments);
        return "question";
    }
}
