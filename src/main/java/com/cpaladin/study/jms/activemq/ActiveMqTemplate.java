/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author cpaladin
 */
public class ActiveMqTemplate {

    private ConnectionFactory connectionFactory;

    public ActiveMqTemplate(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public Connection createConnection() throws JMSException {
        return this.connectionFactory.createConnection();
    }

}
