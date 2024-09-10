package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.dto.MemberDTO;
import com.ssg.web2.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = "/login")
@Log4j2
public class LogInController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    //로그인 화면을 보여줌
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginController GET");
        req.getRequestDispatcher("/todo/login.jsp").forward(req,resp);
    }


    //실제 로그인 처리하도록 구성
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginController POST");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String str = mid + mpw;

        //session값이 처음으로 들어가는 부분
        //HttpSession로 setAttribute를 사용자 공간에 loginInfo 라는 이름으로 문자열을 보관

        try {
            MemberDTO member = memberService.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", member);

            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}