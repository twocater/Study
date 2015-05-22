/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.jms.activemq;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author cpaladin
 */
public class MessageProducerServer {

    private final MessageProducerConfig config;
    private final JmsConnectionTemplate jmsConnectionTemplate;

    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer messageProducer;

    public MessageProducerServer(MessageProducerConfig config) {
        this.config = config;
        this.jmsConnectionTemplate = new JmsConnectionTemplate(config.getFactory(), config.getUrl(),
                config.getConnectionFactoryName(), config.getReconnectDelay(), null);

        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public final void init() throws Exception {
        connection = jmsConnectionTemplate.createConnection();
        session = connection.createSession(config.isTransacted(), config.getAcknowledgeMode());
        messageProducer = session.createProducer(getDestination());
        if (config.isPersistent()) {
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        } else {
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        }
        if (config.getTimeToLive() > 0) {
            messageProducer.setTimeToLive(config.getTimeToLive());
        }
    }

    private Destination getDestination() throws Exception {
        if (destination != null) {
            return destination;
        }
        destination = JmsUtil.findDestination(config.getFactory(), config.getUrl(), config.getDestinationNamePrefix(),
                config.getDestinationName());
        return destination;
    }

    public void publish(String message) {
        try {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setJMSType("111");
            textMessage.setText(message);
            messageProducer.send(textMessage);
            System.out.println("send");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MessageProducerConfig config = new MessageProducerConfig();

        final MessageProducerServer messageProducerServer = new MessageProducerServer(config);

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    messageProducerServer.publish("kdflksdjfksdjfkajfkdfk");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        }).start();
    }
}
