package com.cpaladin.study.jms.activemq;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsUtil {

    public static ConnectionFactory findConnectionFactory(String factory, String url, String connectionFactoryName) throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, factory);
        properties.put(Context.PROVIDER_URL, url);
        properties.put("connectionFactoryNames", connectionFactoryName);
        Context context = new InitialContext(properties);
        return (ConnectionFactory) context.lookup(connectionFactoryName);
    }

    public static Destination findDestination(String factory, String url, String destinationNamePrefix, String destinationName) throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, factory);
        properties.put(Context.PROVIDER_URL, url);
        if (destinationNamePrefix != null) {
            properties.put(destinationNamePrefix + destinationName, destinationName);
        } else {
            properties.put(destinationName, destinationName);
        }
        Context context = new InitialContext(properties);
        return (Destination) context.lookup(destinationName);
    }

    public static void main(String[] args) {
        try {
            System.out.println(findConnectionFactory("org.apache.activemq.jndi.ActiveMQInitialContextFactory",
                    "tcp://10.11.25.101:61616", "ConnectionFactory"));
            System.out.println(findDestination("org.apache.activemq.jndi.ActiveMQInitialContextFactory", "tcp://10.11.25.101:61616",
                    "topic.", "topic_security"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
