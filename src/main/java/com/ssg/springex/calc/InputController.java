package com.ssg.springex.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("InputController... doGet .. processing");
        //jsp를 같이 전달하여 input과 연결해서 페이지를 보여준다
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calc/input.jsp");
        dispatcher.forward(request,response);
    }
}
