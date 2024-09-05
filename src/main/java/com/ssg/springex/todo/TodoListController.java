package com.ssg.springex.todo;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//1. contoller는 HttpServlet를 상속한다.
//2. 어노테이션 지정
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list........ call");
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        req.setAttribute("dtolist",dtoList);//패키징
        //최상위 폴더는 webapp
        //getRequestDispatcher에 jsp파일 경로를 넣어주고 forward에 요청과 응답 파라미터를 넣어준다
        req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
    }
}
