/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.study.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author cpaladin
 */
public class Main {

    public static void main(String[] args) {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            try {
                UserExtendedInfo userExtendedInfo = sqlSession.selectOne("com.cpaladin.study.mybatis.UserExtendedInfoMapper.selectExtendedInfo", "69000015576900");
                System.out.println("---"+userExtendedInfo);
            } finally {
                sqlSession.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
