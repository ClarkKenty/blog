package com.darkcraft.pojo;

import java.util.Date;
import java.util.List;

public class Content {
    private Integer cid;

    private Integer cgid;

    private String category_name;

    private String category_slug;

    private int Comment_count;

    private String title;

    private String slug;

    private Date created_time;

    private Date modified_time;

    private Integer content_order;

    private Integer author_id;

    private String content_type;

    private String content_status;

    private String password;

    private Integer views;

    private String tagList;

    private String content_text;

    private String thumb;

    private String description;

    private List<Tag> tag_list;

    private static final long serialVersionUID = 1L;

    public int getComment_count() {
        return Comment_count;
    }

    public void setComment_count(int comment_count) {
        Comment_count = comment_count;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_slug() {
        return category_slug;
    }

    public void setCategory_slug(String category_slug) {
        this.category_slug = category_slug;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCgid() {
        return cgid;
    }

    public void setCgid(Integer cgid) {
        this.cgid = cgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public Integer getContent_order() {
        return content_order;
    }

    public void setContent_order(Integer content_order) {
        this.content_order = content_order;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type == null ? null : content_type.trim();
    }

    public String getContent_status() {
        return content_status;
    }

    public void setContent_status(String content_status) {
        this.content_status = content_status == null ? null : content_status.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getTagList() {
        return tagList;
    }

    public void setTagList(String tagList) {
        this.tagList = tagList == null ? null : tagList.trim();
    }

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<Tag> getTag_list() {
        return tag_list;
    }

    public void setTag_list(List<Tag> tag_list) {
        this.tag_list = tag_list;
    }

    @Override
    public String toString() {
        return "Content{" +
                "cid=" + cid +
                ", cgid=" + cgid +
                ", categoryName='" + category_name + '\'' +
                ", categorySlug='" + category_slug + '\'' +
                ", CommentCount=" + Comment_count +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", createdTime=" + created_time +
                ", modifiedTime=" + modified_time +
                ", contentOrder=" + content_order +
                ", authorId=" + author_id +
                ", contentType='" + content_type + '\'' +
                ", contentStatus='" + content_status + '\'' +
                ", password='" + password + '\'' +
                ", views=" + views +
                ", tagList='" + tagList + '\'' +
                ", contentText='" + content_text + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                ", tList=" + tag_list +
                '}';
    }
}
