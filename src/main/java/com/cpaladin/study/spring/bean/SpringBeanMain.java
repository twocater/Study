/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.spring.bean;

import java.util.Properties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cpaladin
 */
public class SpringBeanMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"services.xml", "daos.xml", "beans.xml"});
        TestService testService = context.getBean("testService", TestService.class);
        testService.test();

        context.getBean("serverProxy", ServerProxy.class).test();
        context.getBean("clientService", ClientService.class).test();
        context.getBean("foo", Foo.class).test();
        context.getBean("user", User.class).test();
        context.getBean("myDataSource");

        PropertyPlaceholderConfigurer properties = context.getBean("mappings", PropertyPlaceholderConfigurer.class);
        
        context.registerShutdownHook();

    }

}
