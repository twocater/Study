/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.zookeeper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 *
 * @author cpaladin
 */
public class InitConfig {

    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("10.11.200.90:2181", 3000, new MyWatcher());
            zk.create("/xlgame", "/xlgame".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/xlgame/user3", "/xlgame/user3".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/xlgame/user3/conf", "/xlgame/user3/conf".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/xlgame/user3/conf/channel.properties", "init".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            byte[] b = zk.getData("/xlgame/user3/conf/channel.properties", true, null);
            System.out.println(new String(b, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyWatcher implements Watcher {

        @Override
        public void process(WatchedEvent we) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
