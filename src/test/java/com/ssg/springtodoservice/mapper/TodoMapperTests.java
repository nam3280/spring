package com.ssg.springtodoservice.mapper;

import com.ssg.springtodoservice.domain.TodoVO;
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
public class TodoMapperTests {
    @Autowired(required = false)//해당 객체를 주입받지 못해도 예외 발생 없도록 처리
    private TodoMapper todoMapper;

    @Test
    public void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void insertTest(){
        TodoVO vo = TodoVO.builder().
                    title("테스트").
                    dueDate(LocalDate.of(2024,9,12)).
                    writer("ssg").
                    build();
        todoMapper.insert(vo);
    }
}
