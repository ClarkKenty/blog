package com.darkcraft.service.impl;

import com.darkcraft.dao.ContentDao;
import com.darkcraft.pojo.Content;
import com.darkcraft.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao contentDao;

    @Override
    public ArrayList<Content> SearchAll() {
        return contentDao.SearchContent();
    }

    @Override
    public Content SearchByCid(int cid) {
        return contentDao.SearchContentById(cid);
    }

    @Override
    public int addArticle(String title, String content_text, String created_time, String description, String tag_list) {
        return contentDao.addArticle(title, content_text, created_time, description, tag_list);
    }
}
