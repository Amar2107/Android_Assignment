package com.example.androidassignment;

public class Notice {

    private String title;
    private String date;
    private String noticeText;
    private String teacher_name;
    private String img_url;

    public Notice() {
    }

    public Notice(String title, String date, String noticeText, String teacher_name, String img_url) {
        this.title = title;
        this.date = date;
        this.noticeText = noticeText;
        this.teacher_name = teacher_name;
        this.img_url = img_url;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNoticeText() {
        return noticeText;
    }

    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

}
