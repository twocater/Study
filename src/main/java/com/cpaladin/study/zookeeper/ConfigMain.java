/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.zookeeper;

import com.cpaladin.util.DateUtil;
import org.apache.zookeeper.ZooKeeper;

/**
 *
 * @author cpaladin
 */
public class ConfigMain {

    public static void main(String[] args) {
        try {
            ZooKeeper zk = new ZooKeeper("10.11.200.90:2181", 3000, null);
            zk.setData("/xlgame/user3/conf/channel.properties", (DateUtil.currentString()).getBytes("utf-8"), -1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
