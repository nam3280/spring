package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
class TodoServiceTest {
    private TodoService service;

    @BeforeEach
    public void ready(){
        service = TodoService.INSTANCE;
    }

    @Test
    public void register() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder().title("123").dueDate(LocalDate.now()).build();

        log.info(todoDTO);
        service.register(todoDTO);
    }
}
