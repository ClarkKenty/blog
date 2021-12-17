package com.darkcraft.dao;

import com.darkcraft.pojo.Content;
import com.darkcraft.pojo.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface ContentDao {
    @Select("SELECT * FROM content;")
    ArrayList<Content> SearchContent();

    @Select("SELECT * FROM content WHERE cid = #{cid}")
    Content SearchContentById(int cid);

    @Insert("INSERT INTO content(title,content_text,created_time,description,tag_list) VALUES(#{title},#{content_text},#{created_time},#{description},#{tag_list});")
    int addArticle(@Param("title")String title, @Param("content_text")String content_text, @Param("created_time")String created_time, @Param("description")String description, @Param("tag_list")String tag_list);
}
