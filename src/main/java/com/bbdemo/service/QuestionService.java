package com.bbdemo.service;

import com.bbdemo.dto.PaginationDTO;
import com.bbdemo.dto.QuestionQueryDTO;
import com.bbdemo.dto.QuestionDTO;
import com.bbdemo.exception.CustomizeErrorCode;
import com.bbdemo.exception.CustomizeException;
import com.bbdemo.mapper.QuestionExtMapper;
import com.bbdemo.mapper.QuestionMapper;
import com.bbdemo.mapper.UserMapper;
import com.bbdemo.model.Question;
import com.bbdemo.model.QuestionExample;
import com.bbdemo.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;


    public PaginationDTO List(String search, Integer page, Integer size) {
        String regexp = null;
        if (StringUtils.isNotBlank(search)) {
            regexp = StringUtils.replace(search, " ", "|");
        }
        QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
        questionQueryDTO.setSearch(regexp);
        Integer totalCount = questionExtMapper.countBySearch(questionQueryDTO);
        int totalpage;
        if (totalCount % size == 0) {
            totalpage = totalCount / size;
        } else {
            totalpage = totalCount / size + 1;
        }
        if (page < 0) {
            page = 1;
        }
        if (page > totalpage) {
            page = totalpage;
        }
        Integer offset = size * (page - 1);
        questionQueryDTO.setPage(offset);
        questionQueryDTO.setSize(size);
        List<Question> questions = questionExtMapper.selectBySearch(questionQueryDTO);
        List<QuestionDTO> questionDTOList = new LinkedList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);
        paginationDTO.setpagination(totalpage, page);
        return paginationDTO;
    }

    public PaginationDTO List(long id, Integer page, Integer size) {
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(id);
        Integer totalCount = (int) questionMapper.countByExample(example);
        Integer totalpage;
        if (totalCount % size == 0) {
            totalpage = totalCount / size;
        } else {
            totalpage = totalCount / size + 1;
        }
        if (page < 0) {
            page = 1;
        }
        if (page > totalpage) {
            page = totalpage;
        }
        Integer offset = size * (page - 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(id);
        questionExample.setOrderByClause("gmt_create desc");
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new LinkedList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);
        paginationDTO.setpagination(totalpage, page);
        return paginationDTO;
    }

    public QuestionDTO findById(long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setUser(user);
        BeanUtils.copyProperties(question, questionDTO);
        return questionDTO;
    }

    public void CreateOrUpdate(Question question) {
        if (question.getId() == null) {
            questionMapper.insertSelective(question);
        } else {
            Question dbquestion = new Question();
            dbquestion.setGmtModified(System.currentTimeMillis());
            dbquestion.setDescription(question.getDescription());
            dbquestion.setTag(question.getTag());
            dbquestion.setTitle(question.getTitle());
            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
            int update = questionMapper.updateByExampleSelective(dbquestion, example);
            if (update != 1) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void incView(long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewCout(1);
        questionExtMapper.incView(question);
    }

    public List<QuestionDTO> selectByTags(QuestionDTO question) {
        String regexp = StringUtils.replace(question.getTag(), ",", "|");
        Question Ques =new Question();
        Ques.setId(question.getId());
        Ques.setTag(regexp);
        List<Question> questions = questionExtMapper.selectByTags(Ques);
        List<QuestionDTO> questionDTOS = questions.stream().map(question1 -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question1,questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOS;
    }
}
