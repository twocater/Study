/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.threadlocal;

/**
 *
 * @author cpaladin
 */
public class Session {

    private static final ThreadLocal<Integer> session = new ThreadLocal<Integer>();

    public static int getSession() {

        Integer integer = session.get();
        if (integer == null) {
            integer = (int) (Math.random() * 100);
            session.set(integer);
        }
        return integer;
    }
}
