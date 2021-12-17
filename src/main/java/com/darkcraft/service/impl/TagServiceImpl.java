package com.darkcraft.service.impl;

import com.darkcraft.dao.TagDao;
import com.darkcraft.pojo.Content;
import com.darkcraft.pojo.Tag;
import com.darkcraft.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public ArrayList<Tag> SearchAll(){
        return tagDao.SearchTag();
    }

    @Override
    public int AddTag(String name){
        return tagDao.AddTag(name);
    }

    @Override
    public Tag FindTag(String name){
        return tagDao.FindTag(name);
    }

    @Override
    public Tag FindTagByTid(String tid){
        return tagDao.FindTagByTid(tid);
    }

    @Override
    public ArrayList<ArrayList<String>> findTagInContents(ArrayList<Content> contents){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(int i =0;i<contents.size();i++){
            ArrayList<String> tagsInContent = new ArrayList<>();
            String this_tags = tagDao.FindTagByCid(contents.get(i).getCid());
            if(this_tags==null){
                res.add(tagsInContent);
                continue;
            }
            for (String tag: this_tags.split(",")){
                tagsInContent.add(tag);
            }
            res.add(tagsInContent);
        }
        return res;
    }
}
