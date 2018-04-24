package com.lvtinger.demo.domain;

import java.util.Date;

public class User extends PersistentObject implements UserValidate{
    private String nickname;
    private Date birthday;
    private Integer gender;

    public User() {
    }

    public User(String nickname, Date birthday, Integer gender) {
        this.nickname = nickname;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean validate() {
        return false;
    }
}