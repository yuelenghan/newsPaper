package com.ghtn.util;

import org.junit.Test;

/**
 * User: Administrator
 * Date: 13-12-13
 * Time: 上午9:41
 */
public class StringUtilTest {

    @Test
    public void testSubstring() {
        String s1 = "001/002/003/004";
        /*System.out.println(s1.substring(s1.lastIndexOf("/") + 1, s1.length()));
        String s2 = s1.substring(0, s1.lastIndexOf("/"));
        System.out.println(s2);*/
        String[] s = s1.split("/");
        s[2] = "555";
        StringBuffer s2 = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            s2.append(s[i] + "/");
        }
        s2.deleteCharAt(s2.length() - 1);
        System.out.println(s2);
    }

}
