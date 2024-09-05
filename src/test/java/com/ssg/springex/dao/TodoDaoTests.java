package com.ssg.springex.dao;

import com.ssg.springex.jdbcex.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
