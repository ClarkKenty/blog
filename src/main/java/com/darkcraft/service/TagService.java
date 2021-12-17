package com.darkcraft.service;

import com.darkcraft.pojo.Content;
import com.darkcraft.pojo.Tag;

import java.util.ArrayList;

public interface TagService {
    ArrayList<Tag> SearchAll();
    int AddTag(String name);
    Tag FindTag(String name);
    Tag FindTagByTid(String tid);
    ArrayList<ArrayList<String>> findTagInContents(ArrayList<Content> contents);
}
