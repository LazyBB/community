package com.bbdemo.mapper;

import com.bbdemo.model.Question;
import com.bbdemo.model.QuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectByTags(Question record);
}
