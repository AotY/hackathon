package com.xjtu.pojo;

import java.util.Date;

public class Carousel {
    private Integer id;

    private String keyword;

    private String image;

    private Date createTime;

    private Date updateTime;

    public Carousel(Integer id, String keyword, String image, Date createTime, Date updateTime) {
        this.id = id;
        this.keyword = keyword;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Carousel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}