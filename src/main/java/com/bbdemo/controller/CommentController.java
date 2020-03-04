package com.bbdemo.controller;

import com.bbdemo.dto.CommentDTO;
import com.bbdemo.dto.CommentUserDTO;
import com.bbdemo.dto.ResultDTO;
import com.bbdemo.enums.CommentTypeEnum;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.model.Comment;
import com.bbdemo.model.User;
import com.bbdemo.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (commentDTO == null || StringUtils.isBlank(commentDTO.getComment())) {
            return ResultDTO.errorOf(CustomizeErrorCode.COMMENT_IS_EMPTY);
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

    @ResponseBody
    @GetMapping(value = "/comment/{id}")
    public ResultDTO<List> comments(@PathVariable(name = "id") long id) {
        List<CommentUserDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.COMMENT.getType());
        return ResultDTO.okOf(comments);
    }
}
