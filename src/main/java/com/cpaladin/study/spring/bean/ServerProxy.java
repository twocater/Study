/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.spring.bean;

/**
 *
 * @author cpaladin
 */
public class ServerProxy {

    private static final ServerProxy instance = new ServerProxy();

    private ServerProxy() {
    }

    public static ServerProxy getInstance() {
        return instance;
    }

    public void test() {
        System.out.println("test server proxy.");
    }

}
