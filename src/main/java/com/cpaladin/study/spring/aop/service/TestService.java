/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.spring.aop.service;

/**
 *
 * @author cpaladin
 */
public class TestService {

    public int service(String str) throws Exception {
        try {
            System.out.println(str);
            System.out.println("TestService.service.");
            return 1;
        } finally {
            System.out.println("service finally.");
//            throw new RuntimeException("test exception");
        }
//        throw new RuntimeException("test exception.");
    }

}
