package com.myloginin.filter;

import com.myloginin.database.MyDB;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
@WebFilter("/*")
//拦截所有访问
//写可以放行的资源
//第一步放行无需登录就可访问的页面 进行判断
//第二步就是放行静态资源 生命image js css
//登录之后应该放行登录后可以访问的资源
//通过存session来放行 登陆成功有session 登陆状态检查以下 有session放行
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行登录页面
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //找到访问页面
        String url = request.getRequestURI();
        if(url.contains("/login.jsp")||url.contains("/mydb")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //放行静态 图片生命也可以放行
        if(url.contains("/css")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;

        }
        //放行有session的资源
        String uname = (String) request.getSession().getAttribute("userName");
        if(uname!= null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;

        }
    }
}