package com.ssg.web2.todo.service;

import com.ssg.web2.todo.domain.TodoVO;
import com.ssg.web2.todo.dto.TodoDTO;
import com.ssg.web2.todo.util.ModelUtil;
import com.ssg.web2.todo.dao.TodoDAO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;
    private TodoDAO dao;
    private ModelMapper modelMapper;
    TodoService(){
        dao = new TodoDAO(); //직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public void register(TodoDTO dto) throws Exception{
        TodoVO vo = modelMapper.map(dto,TodoVO.class);

        log.info(vo);

        dao.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception{
        List<TodoVO> voList = dao.selectAllList();
        log.info("..........................");
        log.info(voList);
        log.info("..........................");

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;
    }


    //version 1
    //글 하나를 등록하는 기능
//    public void register(TodoDTO dto){
//        System.out.println("DEBUG.........." + dto);
//    }



    //등록된 글의 목록을 반환하는 기능
    //10개의 TodoDTO(글)을 만들어서 반환
//    public List<TodoDTO> getList(){
//        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{
//            TodoDTO dto = new TodoDTO();
//            dto.setTno((long)i);
//            dto.setTitle("Todo...." + i);
//            dto.setDueDate(LocalDate.now());
//            return dto;
//        }).collect(Collectors.toList());
//
//        return todoDTOS;
//    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno = " + tno);
        TodoVO vo = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno = " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO dto) throws Exception {
        log.info("dto = " + dto);
        TodoVO vo = modelMapper.map(dto,TodoVO.class);
        dao.updateOne(vo);
    }
}
//enum 사용이유 : 정해진 수만큼 객체를 생성할 수 있다.
//TodoService.INSTANCE(한 개의 서비스 객체를 사용하겠다는 뜻)
// -> 싱글톤패턴을 적용하여 서비스하겠다.
//여러개의 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고받는 구조로 만들기 위해 객체를 하나만 생성