package com.bbdemo.bbdemo.mapper;

import com.bbdemo.bbdemo.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    public void Create(Question question);
    @Select("select * from question")
    List<Question> List();
}
