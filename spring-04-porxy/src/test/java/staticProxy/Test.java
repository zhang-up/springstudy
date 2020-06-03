package staticProxy;

import com.staticProxy.LoginService;
import com.staticProxy.LoginServiceImpl;
import com.staticProxy.LoginServiceProxy;

public class Test {
	@org.junit.Test
	public void Test(){
		LoginService realLoginService=new LoginServiceImpl();//被代理对象
		LoginService loginServiceProxy=new LoginServiceProxy(realLoginService);//将被代理对象传入代理对象

		loginServiceProxy.login("user1");
		loginServiceProxy.login("user2");
	}

}
