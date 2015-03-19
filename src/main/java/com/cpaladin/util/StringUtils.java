/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cpaladin.util;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cpaladin
 */
public class StringUtils {

    private static final String EMPTY = "";
    private static final String BLANK = " ";

    public static String toString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> iterator = list.iterator();
        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        while (iterator.hasNext()) {
            sb.append(" ").append(iterator.next());
        }
        return sb.toString();
    }

}
