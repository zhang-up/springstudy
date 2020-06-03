package com.project.config;

import com.project.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.project.pojo")//有了扫描，不需要下面的bean配置也可
public class ZConfig {
//    @Bean(name = "user") //加上bean代表将此对象交给IOC容器保管
//    public User getUser(){
//        return  new User();
//    }

}
