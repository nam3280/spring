package com.ssg.springex.dao;


import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDaoTests {
    TodoDAO dao = new TodoDAO();
    @Test
    public void testInsert() throws Exception{
        TodoVO vo = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2024,9,5))
                .build();

        dao.insert(vo);
    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = dao.selectAllList();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 1L;
        TodoVO vo = dao.selectOne(tno);
        System.out.println(vo);
    }

    @Test
    public void testUpdatetOne() throws Exception{
        TodoVO voTest = TodoVO.builder()
                .tno(2L)
                .title("Update test.....")
                .dueDate(LocalDate.of(2022,9,19))
                .finished(true)
                .build();
        dao.updateOne(voTest);
    }
}
