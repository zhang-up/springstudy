import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.pojo.User;
import com.project.service.serviceImpl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class Test {
	InputStream in;
	SqlSessionFactoryBuilder builder;
	SqlSessionFactory factory;
	SqlSession session;
	UserDao userDao;
	//@Before
	public void init()throws  Exception{
		//1.读取配置文件

		in = Resources.getResourceAsStream("mybatis-config.xml");
		//2.创建sqlSessionFactory工厂
		builder = new SqlSessionFactoryBuilder();
		factory = builder.build(in);
		//3.使用工厂生产sqlSession对象
		session = factory.openSession(true);
		//4.使用sqlSession创建Dao接口的代理对象
		userDao = session.getMapper(UserDao.class);

	}
	//@After
	public void destory()throws Exception{
		session.commit();
		session.close();
		in.close();
	}
	@org.junit.Test
	public void test(){
		List<User> users = userDao.selectUser();
		for (User user : users) {
			System.out.println(user);
		}
	}
	//整合之后
	@org.junit.Test
	public void test01(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserDaoImpl userService = context.getBean("userDaoImpl", UserDaoImpl.class);
		List<User> users = userService.selectUser();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
