/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.studyspring.aop.service;

/**
 *
 * @author cpaladin
 */
public class ServiceManager {
    
    private TestService testService = new TestService();

    public TestService getTestService() {
        return testService;
    }
    
    
    
}
