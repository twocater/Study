package com.cpaladin.study.jms.activemq;

import javax.jms.Session;

public class MessageProducerConfig {

    private String factory = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
    private String url = "tcp://10.11.200.90:61616";
    private String connectionFactoryName = "ConnectionFactory";
    private boolean persistent = true;
    private boolean transacted = false;
    private int acknowledgeMode = Session.AUTO_ACKNOWLEDGE;
    private String destinationNamePrefix = "topic.";
    private String destinationName = "topic_myTopic";
    private int timeToLive = 86400;
    private int reconnectDelay;

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

    public boolean isPersistent() {
        return persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
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

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public int getReconnectDelay() {
        return reconnectDelay;
    }

    public void setReconnectDelay(int reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
    }

    @Override
    public String toString() {
        return "MessageProducerConfig [factory=" + factory + ", url=" + url + ", connectionFactoryName=" + connectionFactoryName
                + ", persistent=" + persistent + ", transacted=" + transacted + ", acknowledgeMode=" + acknowledgeMode
                + ", destinationNamePrefix=" + destinationNamePrefix + ", destinationName=" + destinationName + ", timeToLive="
                + timeToLive + ", reconnectDelay=" + reconnectDelay + "]";
    }

}
