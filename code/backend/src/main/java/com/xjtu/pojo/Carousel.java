package com.xjtu.pojo;

import java.util.Date;

public class Carousel {
    private Integer id;

    private String keyword;

    private String image;

    private Date createtime;

    private Date updatetime;

    public Carousel(Integer id, String keyword, String image, Date createtime, Date updatetime) {
        this.id = id;
        this.keyword = keyword;
        this.image = image;
        this.createtime = createtime;
        this.updatetime = updatetime;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}