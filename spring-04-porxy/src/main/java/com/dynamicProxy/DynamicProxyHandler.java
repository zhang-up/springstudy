package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler  implements InvocationHandler {
	private LoginService realLoginService;

	//将被代理对象的引用传递进来
	public DynamicProxyHandler(LoginService realLoginService){
		this.realLoginService=realLoginService;
	}
	/*
	 * TODO 作用：获取被代理对象的实例-->
	 * TODO 本类没有直接实现被代理对象的接口，所以需要使用反射获取被代理对象的实例
	 **/
	public LoginService getProxyInstance(){
		return (LoginService) Proxy.newProxyInstance(
				this.getClass().getClassLoader(),
				realLoginService.getClass().getInterfaces(),this);
	}

	/*
	 * TODO invoke：书写代理逻辑-->对被代理对象的增强在此实现
	 **/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String userID= (String) args[0];
		if(userID.equalsIgnoreCase("user1")){
			System.out.println("你的账号涉嫌违规，禁止登录。");
			return null;
		}
		method.invoke(realLoginService,userID);
		return null;
	}
}
