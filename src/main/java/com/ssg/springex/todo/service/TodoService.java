package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    //글 하나를 등록하는 기능
    public void register(TodoDTO dto){
        System.out.println("DEBUG.........." + dto);
    }

    //등록된 글의 목록을 반환하는 기능
    //10개의 TodoDTO(글)을 만들어서 반환
    public List<TodoDTO> getList(){
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo...." + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }
}

//enum 사용이유 : 정해진 수만큼 객체를 생성할 수 있다.
//TodoService.INSTANCE(한 개의 서비스 객체를 사용하겠다는 뜻)
// -> 싱글톤패턴을 적용하여 서비스하겠다.
//여러개의 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 만들기 위해 객체를 하나만 생성