package com.bbdemo.bbdemo.service;

import com.bbdemo.bbdemo.dto.PaginationDTO;
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


    public PaginationDTO List(Integer page, Integer size) {
        Integer totalCount = questionMapper.count();
        Integer totalpage;
        if (totalCount % size == 0) {
            totalpage = totalCount / size;
        } else {
            totalpage = totalCount / size + 1;
        }
        if (page<0){
            page=1;
        }
        if (page>totalpage){
            page=totalpage;
        }
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.List(offset, size);
        List<QuestionDTO> questionDTOList = new LinkedList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setpagination(totalpage,page);
        return paginationDTO;
    }

    public PaginationDTO List(Integer id, Integer page, Integer size) {
        Integer totalCount = questionMapper.countById(id);
        Integer totalpage;
        if (totalCount % size == 0) {
            totalpage = totalCount / size;
        } else {
            totalpage = totalCount / size + 1;
        }
        if (page<0){
            page=1;
        }
        if (page>totalpage){
            page=totalpage;
        }
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.ListById(id,offset, size);
        List<QuestionDTO> questionDTOList = new LinkedList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        paginationDTO.setpagination(totalpage,page);
        return paginationDTO;
    }
}
