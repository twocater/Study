/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.jms.activemq;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 *
 * @author cpaladin
 */
public class MessageConsumerServer {

    private MessageConsumerConfig config;
    private final JmsConnectionTemplate jmsConnectionTemplate;

    private String selector;

    private Connection connection;
    private Topic topic;
    private Session session;
    private TopicSubscriber topicSubscriber;

    public MessageConsumerServer(MessageConsumerConfig config) {
        this.config = config;
        this.jmsConnectionTemplate = new JmsConnectionTemplate(config.getFactory(), config.getUrl(),
                config.getConnectionFactoryName(), config.getReconnectDelay(), null);
        this.selector = "JMSType<>'" + "123456'";
        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final void init() throws Exception {
        connection = jmsConnectionTemplate.createConnection();
        connection.setClientID(config.getClientid());
        connection.setExceptionListener(new ExceptionListener() {

            @Override
            public void onException(JMSException exception) {
                exception.printStackTrace();
            }
        });
        session = connection.createSession(config.isTransacted(), config.getAcknowledgeMode());
        topicSubscriber = session.createDurableSubscriber(getTopic(), config.getSubscriberName(), selector, true);
        topicSubscriber.setMessageListener(config.getMessageListener());
        connection.start();
    }

    private Topic getTopic() throws Exception {
        if (topic != null) {
            return topic;
        }
        topic = (Topic) JmsUtil.findDestination(config.getFactory(), config.getUrl(), config.getDestinationNamePrefix(),
                config.getDestinationName());
        return topic;
    }

    public static void main(String[] args) {
        MessageConsumerConfig config = new MessageConsumerConfig();
        MessageConsumerServer server = new MessageConsumerServer(config);
    }
}
