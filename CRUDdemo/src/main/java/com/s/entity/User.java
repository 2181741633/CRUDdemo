package com.s.entity;

public class User {
    private Integer uId;

    private String uName;

    private String uEmail;

    private String uGender;

    private Integer dId;

    private Dept dept;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uGender='" + uGender + '\'' +
                ", dId=" + dId +
                ", dept=" + dept +
                '}';
    }

    public User(Integer uId, String uName, String uEmail, String uGender, Integer dId) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uGender = uGender;
        this.dId = dId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender == null ? null : uGender.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}