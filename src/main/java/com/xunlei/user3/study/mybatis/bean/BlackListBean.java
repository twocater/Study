/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatis.bean;

/**
 *
 * @author cpaladin
 */
public class BlackListBean {

    private String gameid;
    private long xlinternalno;

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public long getXlinternalno() {
        return xlinternalno;
    }

    public void setXlinternalno(long xlinternalno) {
        this.xlinternalno = xlinternalno;
    }

    @Override
    public String toString() {
        return gameid + ":" + xlinternalno;
    }

}
