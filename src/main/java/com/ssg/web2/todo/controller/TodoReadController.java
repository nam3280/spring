package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

            //쿠키 찾기
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = true;

            if(todoListStr != null && todoListStr.indexOf(tno + "-") >= 0)
                exist = true;

            log.info("exist : " + exist);

            if(!exist){
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60);
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }
            //요청을 페이지(jsp)로 이동
            req.getRequestDispatcher("/todo/read.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read page error");
        }
    }

// doGet viewTodos 이름의 쿠키를 찾고 쿠키의 내용물을 검사 후 조회한 적이 없는 번호라면
// 쿠키의 내용물을 갱신해서 브라우저로 보내는 기능
    private Cookie findCookie(Cookie[] cookies, String cookieName){
        Cookie targetCookie = null;
        if(cookies != null && cookies.length > 0){
            for (Cookie ck : cookies) {
                if(ck.getName().equals(cookieName)){
                    targetCookie = ck;
                    break;
                }
            }
        }

        if(targetCookie == null){
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60 * 60 * 1);
        }

        return targetCookie;
    }
}
// 1. 현재 요청에 있는 모든 쿠키중에 조회 목록 쿠키(viewTodos)를 찾아내는 메소드 작성
// 2. 특정 tno 쿠키의 내용물이 있는지 확인하는 코드 작성
