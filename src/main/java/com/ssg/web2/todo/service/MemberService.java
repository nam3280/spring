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

    public boolean login(MemberDTO dto){
        log.info("dto = " + dto);
        MemberVO vo = modelMapper.map(dto,MemberVO.class);

        vo = dao.getWithPassword(vo.getMid(), vo.getMpw());

        Optional<String> optionalString = Optional.ofNullable(vo.getMname());

        return optionalString.isPresent();
    }
}