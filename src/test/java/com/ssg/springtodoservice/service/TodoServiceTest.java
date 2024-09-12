package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
//경로를 주입해줘야 한다.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoServiceTest {
    @Autowired(required = false)//해당 객체를 주입받지 못해도 예외 발생 없도록 처리
    private TodoService todoService;
    @Test
    void testRegister(){
        TodoDTO dto = TodoDTO.builder().
                      title("test").
                      dueDate(LocalDate.of(2024,9,12)).
                      writer("ssg").
                      build();
        todoService.register(dto);
    }
}
