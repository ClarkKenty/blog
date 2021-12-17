package com.darkcraft.service;

import com.darkcraft.pojo.Content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public interface ContentService {
    ArrayList<Content> SearchAll();
    Content SearchByCid(int cid);
    int addArticle(String title, String content_text, String  created_time, String description, String tag_list);
}
