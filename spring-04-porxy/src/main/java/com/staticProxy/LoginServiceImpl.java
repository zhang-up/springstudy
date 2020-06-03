package com.staticProxy;

public class LoginServiceImpl implements LoginService{
    @Override
    public void login(String userID) {
        System.out.println("登陆成功");
    }
}
