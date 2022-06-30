package com.myloginin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class Listener01 implements HttpSessionListener {
    private Integer onlineNumber = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session创建");
        onlineNumber++;
        System.out.println("当前人数"+onlineNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁");
        onlineNumber--;
        System.out.println("当前人数"+onlineNumber);
    }
}
