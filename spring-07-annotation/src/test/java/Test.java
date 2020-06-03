import com.project.service.IAccountService;
import com.project.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @Autowired
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountServiceImpl");
        //3.执行方法
        as.saveAccount();
    }
}
