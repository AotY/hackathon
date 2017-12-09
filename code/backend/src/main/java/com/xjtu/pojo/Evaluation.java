package com.xjtu.pojo;

import java.util.Date;

public class Evaluation {
    private Integer fromuserid;

    private Integer touserid;

    private String evaluationlabel;

    private String evaluationtext;

    private Float rating;

    private String mainimage;

    private String subimages;

    private Date createtime;

    private Date updatetime;

    public Evaluation(Integer fromuserid, Integer touserid, String evaluationlabel, String evaluationtext, Float rating, String mainimage, String subimages, Date createtime, Date updatetime) {
        this.fromuserid = fromuserid;
        this.touserid = touserid;
        this.evaluationlabel = evaluationlabel;
        this.evaluationtext = evaluationtext;
        this.rating = rating;
        this.mainimage = mainimage;
        this.subimages = subimages;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public Evaluation() {
        super();
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

    public String getEvaluationlabel() {
        return evaluationlabel;
    }

    public void setEvaluationlabel(String evaluationlabel) {
        this.evaluationlabel = evaluationlabel == null ? null : evaluationlabel.trim();
    }

    public String getEvaluationtext() {
        return evaluationtext;
    }

    public void setEvaluationtext(String evaluationtext) {
        this.evaluationtext = evaluationtext == null ? null : evaluationtext.trim();
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getMainimage() {
        return mainimage;
    }

    public void setMainimage(String mainimage) {
        this.mainimage = mainimage == null ? null : mainimage.trim();
    }

    public String getSubimages() {
        return subimages;
    }

    public void setSubimages(String subimages) {
        this.subimages = subimages == null ? null : subimages.trim();
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