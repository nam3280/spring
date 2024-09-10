package com.ssg.web2.todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "logoutController", urlPatterns = "/login")
@WebServlet("/logout")
@Log4j2
public class LogOutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LogOutController POST");

        HttpSession session = req.getSession();

        session.removeAttribute("loginInfo");//쿠키 삭제
        session.invalidate();//세션 종료

        resp.sendRedirect("/");
    }
}

