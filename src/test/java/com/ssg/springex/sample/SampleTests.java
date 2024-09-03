package com.ssg.springex.sample;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@Log4j2
@ExtendWith(SpringExtension.class) //Junit5 'Spring-test'를 이용하기 위한 설정
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
//스프링의 설정정보를 로딩하기 위한 어노테이션
public class SampleTests {
    @Autowired
    private SampleService sampleService;

    //DI컨테이너에서 생성하고 관리하는 객체를 확인할 수 있다.
    @Test
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }
}