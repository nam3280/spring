package com.ssg.springex.todo.dao;

import com.ssg.springex.jdbcex.ConnectionUtil;
import com.ssg.springex.todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
//    String now = null;
//    public String getTime(){
//        try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
//            PreparedStatement psmt = connection.prepareStatement("select now()");
//            ResultSet rs = psmt.executeQuery();
//        ){
//            rs.next();
//            now = rs.getString(1);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return now;
//    }
//
//    //lombok에 의존하는 코드
//    public String getTime2() throws Exception{
//        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
//        @Cleanup PreparedStatement psmt = connection.prepareStatement("select now()");
//        @Cleanup ResultSet rs = psmt.executeQuery();
//
//        rs.next();
//
//        now = rs.getString(1);
//
//        return now;
//    }

    public void insert(TodoVO vo) throws Exception{
        String sql = "insert into tbl_todo(tno,title,dueDate,finished) value(null,?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3,vo.isFinished());

        pstmt.executeUpdate();
    }

    public List<TodoVO> selectAllList() throws Exception{
        String sql = "select * from tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVO> list =new ArrayList<>();

        while (rs.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();

            list.add(vo);
        }

        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception{
        String sql = "select * from tbl_todo where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
        return vo;
    }

    public void deleteOne(Long tno) throws Exception{
        String sql = "delete from tbl_todo where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,tno);
        pstmt.executeUpdate();
    }

    public void updateOne(TodoVO vo) throws Exception{
        String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,vo.getTitle());
        pstmt.setDate(2,Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3, vo.isFinished());
        pstmt.setLong(4,vo.getTno());
        pstmt.executeUpdate();
    }
}
