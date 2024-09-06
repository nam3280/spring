package com.ssg.w1.todo.service;


import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public enum TodoService {
    INSTANCE;
    private final TodoDAO dao = new TodoDAO();

    public List<TodoDTO> getList(){
        return dao.getList();
    }

    public TodoDTO get(Long tno){
        return dao.get(tno);
    }

    public void createTodo(TodoDTO dto){
        dao.insert(dto);
    }
    public void updateTodo(TodoDTO dto){dao.update(dto);}
    public void deleteTodo(String tno){dao.delete(tno);}
}