package staticProxy;

import com.dynamicProxy.DynamicProxyHandler;
import com.dynamicProxy.LoginService;
import com.dynamicProxy.LoginServiceImpl;
import org.junit.Test;

public class DynamicProxyTest {
	@Test
	public void Test() {
		LoginService realLoginService=new LoginServiceImpl();//被代理对象(真实的对象)
		LoginService proxyInstance=
				new DynamicProxyHandler(realLoginService).getProxyInstance();//创建代理对象的实例
		proxyInstance.login("user1");
		proxyInstance.login("user2");
	}
	//查看代理对象
	@Test
	public void Test02(){
		LoginService realLoginService=new LoginServiceImpl();//被代理对象
		LoginService proxyInstance=
				new DynamicProxyHandler(realLoginService).getProxyInstance();//创建代理对象的实例
		System.out.println(proxyInstance.getClass().getName());
		Class<?>[] interfaces = proxyInstance.getClass().getInterfaces();//获取代理对象的接口
		for (Class<?> anInterface : interfaces) {
			System.out.println("interface--"+anInterface);
		}
		/*
		 * TODO superclass--class java.lang.reflect.Proxy
		 * TODO 可知代理对象已经继承了Proxy类，所有被代理对象和代理对象必须是实现接口
		 **/
		Class<?> superclass = proxyInstance.getClass().getSuperclass();//获取代理对象的父类
		for (Class<?> anInterface : interfaces) {
			System.out.println("superclass--"+superclass);
		}
	}
}
