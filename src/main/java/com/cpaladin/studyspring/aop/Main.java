/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.studyspring.aop;

import com.cpaladin.studyspring.aop.service.ServiceManager;
import com.cpaladin.studyspring.aop.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cpaladin
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aops.xml");

        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.service("abc");
    }

}
