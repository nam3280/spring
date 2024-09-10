package com.ssg.web2.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// urlPatterns를 지정해서 해당 경로의 요청에 대해서 doFilter를 실행
@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
// LoginCheckFilter는 urlPatterns이 지정되어 브라우저에서 /todo/로 시작하는 모든 경로에 대해 필터링 시도 
public class LoginCheckFilter implements Filter {

    //filter 인터페이스의 doFilter는 필터링이 필요한 로직을 구현하는 메소드
    //필터를 적용하기 위해서는 @WebFilter 처리 필수
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
       log.info("LoginCheckFilter Filter");

       //ServletRequest이 HttpServletRequest보다 상위이므로 형변환
       HttpServletRequest req = (HttpServletRequest)request;
       HttpServletResponse resp = (HttpServletResponse)response;
       HttpSession session = req.getSession();

       if(session.getAttribute("loginInfo") == null){
           resp.sendRedirect("/login");
           return ;
       }

       //다음 필터나 목적지로 갈 수 있도록 처리
       filterChain.doFilter(req,resp);
    }
}
//로그인을 하지 않으면 todo로 접근할 때 필터링 되어 login으로 다시 돌아간다.