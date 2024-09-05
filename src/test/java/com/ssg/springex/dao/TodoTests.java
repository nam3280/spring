package com.ssg.springex.dao;

import com.ssg.springex.jdbcex.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoTests {
    private TodoDAO todoDAO;

    @BeforeEach //ready()를 통해서 모든 테스트 전에 TodoDao타입의 객체 생성
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime(){
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }
}
