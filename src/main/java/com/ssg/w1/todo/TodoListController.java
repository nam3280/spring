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
import java.util.List;

@WebServlet(name = "TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("List GET");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/list.jsp");
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        System.out.println(dtoList);
        req.setAttribute("dtoList",dtoList);//패키징
        dispatcher.forward(req,resp);
    }
}
