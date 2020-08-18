package com.jk.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    private Integer userId;
    private String userName;
    private String gender;
    private String birthday;
    private Integer hobbyId;
    private String hobbyName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", hobbyId=" + hobbyId +
                ", hobbyName='" + hobbyName + '\'' +
                '}';
    }
}
