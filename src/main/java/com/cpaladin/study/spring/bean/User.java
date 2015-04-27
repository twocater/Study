/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author cpaladin
 */
public class User {

    private String name;
    private int age;

    private String address;
    private City city;

    private Properties adminEmails;
    private List someList;
    private Map someMap;
    private Set someSet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void init() {
        System.out.println("init user.");
    }

     public void cleanup() {
        System.out.println("cleanup user.");
    }
     
     
    public void test() {
        System.out.println("name:" + name + ",age:" + age + ",address:" + address + ",city:" + city);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public void setSomeList(List someList) {
        this.someList = someList;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }

    public void setSomeSet(Set someSet) {
        this.someSet = someSet;
    }

}
