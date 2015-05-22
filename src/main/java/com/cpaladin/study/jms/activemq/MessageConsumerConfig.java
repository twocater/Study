package com.cpaladin.study.jms.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

public class MessageConsumerConfig {

    private String factory = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
    private String url = "tcp://10.11.200.90:61616";
    private String connectionFactoryName = "ConnectionFactory";
    private boolean transacted = false;
    private int acknowledgeMode = Session.AUTO_ACKNOWLEDGE;
    private String destinationNamePrefix = "topic.";
    private String destinationName = "topic_myTopic";
    private String clientid = "clientid";
    private String subscriberName = "clientid";
    private MessageListener messageListener;
    private int reconnectDelay;

    public MessageConsumerConfig() {
        this.messageListener = new MessageListener() {

            @Override
            public void onMessage(Message message) {
                System.out.println(message);
            }
        };
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConnectionFactoryName() {
        return connectionFactoryName;
    }

    public void setConnectionFactoryName(String connectionFactoryName) {
        this.connectionFactoryName = connectionFactoryName;
    }

    public boolean isTransacted() {
        return transacted;
    }

    public void setTransacted(boolean transacted) {
        this.transacted = transacted;
    }

    public int getAcknowledgeMode() {
        return acknowledgeMode;
    }

    public void setAcknowledgeMode(int acknowledgeMode) {
        this.acknowledgeMode = acknowledgeMode;
    }

    public String getDestinationNamePrefix() {
        return destinationNamePrefix;
    }

    public void setDestinationNamePrefix(String destinationNamePrefix) {
        this.destinationNamePrefix = destinationNamePrefix;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public MessageListener getMessageListener() {
        return messageListener;
    }

    public void setMessageListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    public int getReconnectDelay() {
        return reconnectDelay;
    }

    public void setReconnectDelay(int reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
    }

    @Override
    public String toString() {
        return "MessageConsumerConfig [factory=" + factory + ", url=" + url + ", connectionFactoryName=" + connectionFactoryName
                + ", transacted=" + transacted + ", acknowledgeMode=" + acknowledgeMode + ", destinationNamePrefix="
                + destinationNamePrefix + ", destinationName=" + destinationName + ", clientid=" + clientid + ", subscriberName="
                + subscriberName + ", messageListener=" + messageListener + ", reconnectDelay=" + reconnectDelay + "]";
    }

}
