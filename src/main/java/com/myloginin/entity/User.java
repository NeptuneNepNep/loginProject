package com.myloginin.entity;

public class User {
    int userId;
    String userName;
    String userPwd;
    int userAge;
    public  User() {


    };
    public User(int userId, String userName, String userPwd, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
