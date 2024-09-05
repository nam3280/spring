package com.ssg.springex.jdbcex;

import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
