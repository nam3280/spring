package com.ssg.springtodoservice.service;

import com.ssg.springtodoservice.domain.TodoVO;
import com.ssg.springtodoservice.dto.TodoDTO;
import com.ssg.springtodoservice.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
//의존성 주입이 필요한 객체의 타입을 final로 고정(빈 고정)시키고 @RequireArgsConstructor를 이용하여 생성자를 생성하는 방식으로 주입받는다.
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;
    @Override
    public void register(TodoDTO dto) {
        log.info(modelMapper);
        TodoVO vo = modelMapper.map(dto,TodoVO.class);
        log.info(vo);
        todoMapper.insert(vo);
    }
}
