/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatisspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cpaladin
 */
public class TestMybatisSpring {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BlackListDAO blackListDAO = applicationContext.getBean("blackListDao", BlackListDAO.class);

        System.err.println(blackListDAO.findBlacklists(125603112));

        BlackListMapper blackListMapper = applicationContext.getBean("blackListMapper", BlackListMapper.class);
        System.err.println(blackListMapper.findBlacklists(125603112));

    }

}
