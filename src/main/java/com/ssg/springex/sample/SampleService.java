package com.ssg.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
@ToString
@RequiredArgsConstructor //생성자 주입 방식으로 수정
public class SampleService {

    @Qualifier("basic") //네이밍을 통해 원하는 인터페이스를 가지오 올 수 있다.
    //느슨한 결합을 위해 리포지토리가 아닌 인터페이스를 생성자로 가지고 온다.
    private final SampleDAO sampleDAO;
}
