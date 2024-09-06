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
import java.time.LocalDate;
import java.util.Optional;

@WebServlet(name="TodoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("modify GET");
        TodoDTO dto = TodoService.INSTANCE.get(Long.parseLong(req.getParameter("tno")));
        req.setAttribute("dto",dto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/todo/modify.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("modify POST");

        String tno = req.getParameter("tno");
        String title = req.getParameter("title");
        String dueDate = req.getParameter("dueDate");
        String finished = req.getParameter("finished");

        Optional<String> optionalString = Optional.ofNullable(finished);
        if(optionalString.isPresent())
            finished = "true";
        else
            finished = "false";

        TodoDTO dto = new TodoDTO();
        dto.setTno(Long.parseLong(tno));
        dto.setTitle(title);
        dto.setDueDate(LocalDate.parse(dueDate));
        dto.setFinished(Boolean.parseBoolean(finished));

        System.out.println(dto);

        TodoService.INSTANCE.updateTodo(dto);

        resp.sendRedirect("/todo/list");
    }
}
