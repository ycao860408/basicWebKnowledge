package com.atguigu.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies == null || cookies.length == 0 || name == null || name.equals("")) return null;
        Cookie ret = null;
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                ret = cookie;
                break;
            }
        }
        return ret;
    }
}
