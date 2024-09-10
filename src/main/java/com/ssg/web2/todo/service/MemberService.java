package com.ssg.web2.todo.service;

import com.ssg.web2.todo.dao.MemberDAO;
import com.ssg.web2.todo.domain.MemberVO;
import com.ssg.web2.todo.dto.MemberDTO;
import com.ssg.web2.todo.util.ModelUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Log4j2
public enum MemberService {
    INSTANCE;
    private MemberDAO dao;
    private ModelMapper modelMapper;
    MemberService(){
        dao = new MemberDAO(); //직접 dao 주입
        modelMapper = ModelUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);

        MemberDTO dto = modelMapper.map(vo,MemberDTO.class);

        return dto;
    }
}