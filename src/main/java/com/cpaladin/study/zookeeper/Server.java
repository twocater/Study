/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.zookeeper;

import java.io.IOException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 *
 * @author cpaladin
 */
public class Server implements Watcher {

    private String config;
    private ZooKeeper zk;

    public Server() {
        try {
            zk = new ZooKeeper("10.11.9.29:2181", 3000, null);
            byte[] b = zk.getData("/xlgame/user3/conf/channel.properties", this, null);
            config = new String(b, "utf-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent arg0) {
        try {
            byte[] b = zk.getData("/xlgame/user3/conf/channel.properties", this, null);
            config = new String(b, "utf-8");
            System.err.println(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        try {
            zk.close();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public String getConfig() {
        return config;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        System.out.println(server.getConfig());
        System.in.read();

    }

}
