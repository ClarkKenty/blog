package com.darkcraft.controller;

import com.darkcraft.pojo.Content;
import com.darkcraft.pojo.Tag;
import com.darkcraft.service.ContentService;
import com.darkcraft.service.TagService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ArticleController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value = "/book")
    public String toBook(Model model){
        ArrayList<Content> contents = contentService.SearchAll();
        ArrayList<ArrayList<String>> tags = tagService.findTagInContents(contents);
        model.addAttribute("contents",contents);
        model.addAttribute("tags",tags);
        return "/book";
    }

    @RequestMapping(value = "/article")
    public String article(Model model, HttpServletRequest request){
        int cid = Integer.parseInt(request.getParameter("num"));
        Content content = contentService.SearchByCid(cid);
        model.addAttribute("content",content);
        model.addAttribute("cid",cid);
        return "/article";
    }

    @RequestMapping(value = "/postArticle")
    public String postArticle(Model model,String title,String content,String description,String[] tags,HttpServletRequest request){
        String TagIDString="";
        if(tags!=null){
            ArrayList<String> tagIDList = new ArrayList<String>();
            for(int i =0;i<tags.length;i++){
                Tag findTag = tagService.FindTag(tags[i]);
                if(findTag==null){
                    tagService.AddTag(tags[i]);
                }
                findTag = tagService.FindTag(tags[i]);
                tagIDList.add(Integer.toString(findTag.getTid()));
                TagIDString =String.join(",", tagIDList);
            }
        }

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String timeStr = ft.format(dNow);
        int res = contentService.addArticle(title,content,timeStr,description,TagIDString);
        model.addAttribute("res",res);
        return "/compose";
    }
    @RequestMapping(value = "/compose")
    public String compose(){
        return "/compose";
    }
}
