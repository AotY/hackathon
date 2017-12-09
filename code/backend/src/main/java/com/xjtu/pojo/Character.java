package com.xjtu.pojo;

import java.util.Date;

public class Character {
    private Integer id;

    private String label;

    private String type;

    private Date createtime;

    private Date updatetime;

    public Character(Integer id, String label, String type, Date createtime, Date updatetime) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Character() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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