/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatisspring;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 *
 * @author cpaladin
 */
public class BlackListDAO extends SqlSessionDaoSupport {

    public List<String> findBlacklists(long xlinternalno) {
        return getSqlSession().selectList("com.xunlei.user3.study.mybatisspring.BlackListMapper.findBlacklists", xlinternalno);
                                            
    }

}
