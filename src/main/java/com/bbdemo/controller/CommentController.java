package com.bbdemo.controller;

import com.bbdemo.dto.CommentDTO;
import com.bbdemo.dto.ResultDTO;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.mapper.CommentMapper;
import com.bbdemo.model.Comment;
import com.bbdemo.model.User;
import com.bbdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setComment(commentDTO.getComment());
        comment.setType(commentDTO.getType());
        comment.setParentId(commentDTO.getParentId());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommenter(user.getId());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
