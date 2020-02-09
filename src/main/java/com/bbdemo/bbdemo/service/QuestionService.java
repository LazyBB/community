package com.bbdemo.bbdemo.service;

import com.bbdemo.bbdemo.dto.QuestionDTO;
import com.bbdemo.bbdemo.mapper.QuestionMapper;
import com.bbdemo.bbdemo.mapper.UserMapper;
import com.bbdemo.bbdemo.model.Question;
import com.bbdemo.bbdemo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;


    public List<QuestionDTO> List() {
        List<Question> questions = questionMapper.List();
        List<QuestionDTO> questionDTOList = new LinkedList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
