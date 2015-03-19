/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cpaladin
 */
public class BaseDAO {
    
    public void close(SqlSession sqlSession) {
        sqlSession.close();
    }
    
}
