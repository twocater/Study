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
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Session.getSession());
        }

    }
}
