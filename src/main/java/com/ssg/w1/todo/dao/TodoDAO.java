package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TodoDAO {
    public void insert(TodoDTO vo) {
        String sql = "insert into tbl_todo(tno, title, dueDate) values(null,?,?)";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setDate(2, Date.valueOf(vo.getDueDate()));

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<TodoDTO> getList(){
        String sql = "select * from tbl_todo";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            @Cleanup ResultSet rs = pstmt.executeQuery();

            List<TodoDTO> todoDTOS = new ArrayList<>();
            while (rs.next()) {
                    TodoDTO dto = new TodoDTO();
                    dto.setTno(rs.getLong("tno"));
                    dto.setTitle(rs.getString("title"));
                    dto.setDueDate(rs.getDate("dueDate").toLocalDate());
                    dto.setFinished(rs.getBoolean("finished"));

                    todoDTOS.add(dto);
                };
            return todoDTOS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TodoDTO get(Long tno){
        String sql = "select * from tbl_todo where tno = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1,tno);
            @Cleanup ResultSet rs = pstmt.executeQuery();

            rs.next();

            TodoDTO dto = new TodoDTO();

            dto.setTno(rs.getLong("tno"));
            dto.setTitle(rs.getString("title"));
            dto.setDueDate(rs.getDate("dueDate").toLocalDate());
            dto.setFinished(rs.getBoolean("finished"));

            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TodoDTO vo) {
        String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
            pstmt.setBoolean(3,vo.isFinished());
            pstmt.setLong(4, vo.getTno());

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(String tno) {
        String sql = "delete from tbl_todo where tno = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, Long.parseLong(tno));
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
