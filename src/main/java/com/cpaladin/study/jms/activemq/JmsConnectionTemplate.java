/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.jms.activemq;

import java.util.Timer;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author cpaladin
 */
public class JmsConnectionTemplate {

    private String factory;
    private String url;
    private String connectionFactoryName;

    private ConnectionFactory connectionFactory;
    private int reconnectDelay;
    private Recoverable callback;

    private boolean start;
    private boolean ok;// 连接是否正常
    private Timer timer;

    public JmsConnectionTemplate(String factory, String url, String connectionFactoryName, int reconnectDelay, Recoverable callback) {
        this.factory = factory;
        this.url = url;
        this.connectionFactoryName = connectionFactoryName;
        this.reconnectDelay = reconnectDelay;
        this.callback = callback;
        try {
            connectionFactory = JmsUtil.findConnectionFactory(factory, url, connectionFactoryName);
        } catch (NamingException e) {
            System.out.println("JmsUtil.findConnectionFactory error.");
            throw new RuntimeException(e);
        }
    }

    public Connection createConnection() throws JMSException {
        return this.connectionFactory.createConnection();
    }

}
