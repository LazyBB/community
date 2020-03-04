package com.bbdemo.service;

import com.bbdemo.dto.CommentUserDTO;
import com.bbdemo.enums.CommentTypeEnum;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.exception.CustomizeException;
import com.bbdemo.mapper.*;
import com.bbdemo.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;

    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_NOT_FOUND);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment comment1 = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (comment1 == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            Comment comment2 = new Comment();
            comment2.setCommentCount((long) 1);
            comment2.setId(comment.getParentId());
            commentExtMapper.incComment(comment2);
        }
        if (comment.getType() == CommentTypeEnum.QUESTION.getType()) {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insertSelective(comment);
            question.setCommentCout(1);
            questionExtMapper.incCommentCount(question);
        }
    }

    public List<CommentUserDTO> listByTargetId(long id, Integer type) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(type);
        example.setOrderByClause("gmt_create desc");
        List<Comment> comments = commentMapper.selectByExample(example);

        if (comments.size() == 0) {
            return new ArrayList<>();
        }
        Set<Long> commenter = comments.stream().map(comment -> comment.getCommenter()).collect(Collectors.toSet());
        List<Long> userId = new ArrayList<>();
        userId.addAll(commenter);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userId);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
        List<CommentUserDTO> commentList = comments.stream().map(comment -> {
            CommentUserDTO commentUserDTO = new CommentUserDTO();
            BeanUtils.copyProperties(comment, commentUserDTO);
            commentUserDTO.setUser(userMap.get(comment.getCommenter()));
            return commentUserDTO;
        }).collect(Collectors.toList());
        return commentList;
    }
}
