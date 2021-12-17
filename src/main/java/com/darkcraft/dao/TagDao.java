package com.darkcraft.dao;

import com.darkcraft.pojo.Content;
import com.darkcraft.pojo.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface TagDao {
    @Select("SELECT * FROM Tag;")
    ArrayList<Tag> SearchTag();

    @Select("SELECT * FROM tag where name = #{name}")
    Tag FindTag(String name);

    @Select("SELECT * FROM tag where tid = #{tid}")
    Tag FindTagByTid(String tid);

    @Select("SELECT GROUP_CONCAT(tag.name,'') FROM content,tag WHERE content.cid = #{cid} AND find_in_set(tag.tid,content.tag_list);")
    String FindTagByCid(int cid);

    @Insert("INSERT INTO tag(name) values(#{name}); ")
    int AddTag(@Param("name")String name);


}
