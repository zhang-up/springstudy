package com.project.service;

import com.project.dao.UserDao;

public class UserServiceIml implements UserService{
    UserDao userDao;

    public void setUserDao(UserDao userdao){
        this.userDao=userdao;
    }
    public void getUser() {
        userDao.getUser();
    }
}
