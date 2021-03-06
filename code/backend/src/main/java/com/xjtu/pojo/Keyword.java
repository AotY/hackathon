package com.xjtu.pojo;

import java.util.Date;

public class Keyword {
    private Integer id;

    private String keyword;

    private Integer count;

    private Date createtime;

    private Date updatetime;

    public Keyword(Integer id, String keyword, Integer count, Date createtime, Date updatetime) {
        this.id = id;
        this.keyword = keyword;
        this.count = count;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Keyword() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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