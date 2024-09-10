package com.ssg.web2.todo.dao;

import com.ssg.web2.todo.domain.MemberVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
public class MemberDAO {
    public MemberVO getWithPassword(String mid, String mpw) {
        String sql = "SELECT * FROM tbl_member WHERE mid = ? and mpw = ?";

        MemberVO vo = null;
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mid);
            pstmt.setString(2, mpw);
            @Cleanup ResultSet rs = pstmt.executeQuery();

            rs.next();
            vo = MemberVO.builder()
                    .mid(rs.getString("mid"))
                    .mpw(rs.getString("mpw"))
                    .mname(rs.getString("mname"))
                    .build();
        } catch (Exception e){
            log.info(e);
        }
        return vo;
    }
}
