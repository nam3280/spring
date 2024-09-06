package com.ssg.springex.todo.controller;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadContainer", urlPatterns = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("todo/read......실행");

        //todo/read?tno=123
        Long tno = Long.parseLong(req.getParameter("tno"));

        try {
            TodoDTO dto = TodoService.INSTANCE.get(tno);

            //요청을 dto로 매핑
            req.setAttribute("dto",dto);

            //요청을 페이지(jsp)로 이동
            req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read page error");
        }
    }
}
