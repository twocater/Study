/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatis;

import com.cpaladin.util.StringUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cpaladin
 */
public class BlackListDAO {

    public List<String> findBlacklists(long xlinternalno) {
        try (SqlSession sqlSession = TestMyBatis.getSession()) {
            List<String> list = sqlSession.selectList("com.xunlei.user3.mybatis.BlackListMapper.findBlacklists", 125603112);
            return list;
        }
    }

    public int queryBlacklistCount(String gameid) {
        try (SqlSession sqlSession = TestMyBatis.getSession()) {
            return sqlSession.selectOne("com.xunlei.user3.mybatis.BlackListMapper.queryBlacklistCount", gameid);
        }
    }

    public List<Long> findBlacklistUsers(String gameid, int page, int limit) {
        try (SqlSession sqlSession = TestMyBatis.getSession()) {
            return sqlSession.selectList("com.xunlei.user3.mybatis.BlackListMapper.findBlacklistUsers", gameid, new RowBounds(page, limit));

        }
    }

    public List<BlackListBean> findAllBlacklists() {
        try (SqlSession sqlSession = TestMyBatis.getSession()) {
            return sqlSession.selectList("com.xunlei.user3.mybatis.BlackListMapper.findAllBlacklists");
        }
    }

    public static void main(String[] args) throws IOException {
        TestMyBatis.init();
        BlackListDAO dao = new BlackListDAO();

        System.out.println(dao.findBlacklists(125603112));
        System.out.println(dao.queryBlacklistCount("000045"));
        System.out.println(dao.findBlacklistUsers("000045", 2, 1));
        System.out.println(dao.findAllBlacklists());

    }
}
