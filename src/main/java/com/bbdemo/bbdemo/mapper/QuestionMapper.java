package com.bbdemo.bbdemo.mapper;

import com.bbdemo.bbdemo.model.Question;
        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

        import java.util.List;


@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tag})")
    public void Create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> List(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();
    @Select("select * from question where creator=#{id} limit #{offset},#{size}")
    List<Question> ListById(@Param(value = "id")Integer id, @Param(value = "offset")Integer offset, @Param(value = "size")Integer size);

    @Select("select count(1) from question where creator=#{id}")
    Integer countById(@Param(value = "id")Integer id);
}
