package com.staticProxy;

//代理类，需要实现被代理对象的接口，并或得被代理对象的引用，在此类当中对被代理对象业务的增强
public class LoginServiceProxy implements LoginService{
    private LoginService realLoginService;//真实对象的引用

    public LoginServiceProxy(LoginService realLoginService) {
        this.realLoginService = realLoginService;
    }
    @Override
    public void login(String userID) {
        if(losersUser(userID)){
            System.out.println("你的账号涉嫌违规，禁止登录。");
            return ;
        }
        realLoginService.login(userID);
    }
    private boolean losersUser(String userId){
        if(userId.equalsIgnoreCase("user1")){
            return true;
        }
        return false;
    }

}
