package com.ssg.w1.todo;

import com.ssg.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoRemoveController", urlPatterns = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tno = req.getParameter("tno");
        TodoService.INSTANCE.deleteTodo(tno);
        resp.sendRedirect("/todo/list");
    }
}
