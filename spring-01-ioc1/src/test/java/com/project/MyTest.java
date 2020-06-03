package com.project;

import com.project.dao.UserSqlserviceDaoIml;
import com.project.service.UserService;
import com.project.service.UserServiceIml;
import org.junit.Test;

public class MyTest {
    @Test
    public void test1(){

        UserService userService=new UserServiceIml();
        ((UserServiceIml) userService).setUserDao(new UserSqlserviceDaoIml());
        userService.getUser();
    }

}
