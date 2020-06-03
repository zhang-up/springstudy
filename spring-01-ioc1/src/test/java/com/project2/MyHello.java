package com.project2;

import com.project2.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyHello {
    @Test
    public void test(){
        //解析beans.xml文件，生成管理相应的Bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //getBean:参数即为spring配置文件中bean的id
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);
        test2(context);
    }
   // @Test
    public void test2(ApplicationContext context){
        //解析beans.xml文件，生成管理相应的Bean对象
       // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //getBean:参数即为spring配置文件中bean的id
        Hello hello = context.getBean("hello",Hello.class);
        System.out.println(hello);
    }
}
