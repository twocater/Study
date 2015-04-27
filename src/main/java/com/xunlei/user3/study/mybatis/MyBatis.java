/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author cpaladin
 */
public class MyBatis {

    private static SqlSessionFactory master;
    private static SqlSessionFactory slave;

    public static void init() throws IOException {
        master = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"), "master_db");
        slave = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"), "slave_db");
    }

    public static SqlSession getSession() {
        return master.openSession();
    }

}
