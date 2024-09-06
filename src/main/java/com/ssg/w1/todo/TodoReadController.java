package com.ssg.w1.todo;

import com.ssg.w1.todo.dto.TodoDTO;
import com.ssg.w1.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDTO dto = TodoService.INSTANCE.get(Long.parseLong(req.getParameter("tno")));
        req.setAttribute("dto",dto);//패키징
        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/read.jsp");
        dispatcher.forward(req,resp);
    }
}
