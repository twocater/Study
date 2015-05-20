/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xunlei.user3.study.mybatisspring;

import java.util.List;

/**
 *
 * @author cpaladin
 */
public interface BlackListMapper {

    public List<String> findBlacklists(long xlinternalno);

}
