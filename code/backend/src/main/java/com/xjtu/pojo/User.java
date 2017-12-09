package com.xjtu.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String mainimage;

    private String subimages;

    private String sex;

    private Integer age;

    private String hometown;

    private String industry;

    private Integer online;

    private Integer guide;

    private Float longitude;

    private Float latitude;

    private Integer guidecount;

    private Float rating;

    private String personality;

    private String language;

    private String place;

    private String travel;

    private String book;

    private String movie;

    private String music;

    private String food;

    private String sport;

    private String password;

    private String phone;

    private String device;

    private Date createtime;

    private Date updatetime;

    public User(Integer id, String username, String mainimage, String subimages, String sex, Integer age, String hometown, String industry, Integer online, Integer guide, Float longitude, Float latitude, Integer guidecount, Float rating, String personality, String language, String place, String travel, String book, String movie, String music, String food, String sport, String password, String phone, String device, Date createtime, Date updatetime) {
        this.id = id;
        this.username = username;
        this.mainimage = mainimage;
        this.subimages = subimages;
        this.sex = sex;
        this.age = age;
        this.hometown = hometown;
        this.industry = industry;
        this.online = online;
        this.guide = guide;
        this.longitude = longitude;
        this.latitude = latitude;
        this.guidecount = guidecount;
        this.rating = rating;
        this.personality = personality;
        this.language = language;
        this.place = place;
        this.travel = travel;
        this.book = book;
        this.movie = movie;
        this.music = music;
        this.food = food;
        this.sport = sport;
        this.password = password;
        this.phone = phone;
        this.device = device;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getGuide() {
        return guide;
    }

    public void setGuide(Integer guide) {
        this.guide = guide;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Integer getGuidecount() {
        return guidecount;
    }

    public void setGuidecount(Integer guidecount) {
        this.guidecount = guidecount;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality == null ? null : personality.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel == null ? null : travel.trim();
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book == null ? null : book.trim();
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie == null ? null : movie.trim();
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport == null ? null : sport.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
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