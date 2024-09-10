package com.ssg.web2.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//한글 깨짐 필터링
@WebFilter(urlPatterns = {"/*"})
@Log4j2
public class UTF8Filter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("UTF8Filter Filter");

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        req.setCharacterEncoding("UTF-8");

        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        filterChain.doFilter(req, resp);
    }
}
