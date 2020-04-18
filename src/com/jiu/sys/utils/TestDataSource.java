package com.jiu.sys.utils;

import com.jiu.sys.domain.Menu;
import com.jiu.sys.mapper.MenuMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuMapper menuMapper=context.getBean(MenuMapper.class);
        List<Menu> queryAllMenu=menuMapper.querAllMenu(new Menu());
        System.out.println(queryAllMenu.size());
        System.out.println(menuMapper);
        System.out.println("初始化完成");
    }
}
