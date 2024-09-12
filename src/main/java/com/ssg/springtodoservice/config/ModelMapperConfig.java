package com.ssg.springtodoservice.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//ModelMapperConfig는 기존의 MapperUtil클래스를 스프링으로 변경
//@Configuration를 이용하여 스프링 컨테이너 빈으로 등록하여 사용
//@Configuration : 해당 클래스가 스프링 빈에 대한 설정하는 클래스임을 명시
@Configuration
public class ModelMapperConfig {
    //getMapper() : ModelMapper 객체 반환
    //@Bean : getMapper()의 실행 결과로 반환된 객체를 스프링의 빈으로 등록시킨다.
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setFieldMatchingEnabled(true)
                   .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PACKAGE_PRIVATE)
                   .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
