package com.xjtu.pojo;

import java.util.Date;

public class History {
    private Integer id;

    private Integer fromuserid;

    private Integer touserid;

    private String destination;

    private Date createtime;

    private Date updatetime;

    public History(Integer id, Integer fromuserid, Integer touserid, String destination, Date createtime, Date updatetime) {
        this.id = id;
        this.fromuserid = fromuserid;
        this.touserid = touserid;
        this.destination = destination;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public History() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
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