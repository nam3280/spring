package com.ssg.springex.sample;

import org.springframework.stereotype.Repository;

public interface SampleDAO {
}
//느슨한 결합을 이용하여 나중에 SampleDAO 타입의 객체를 다른 객체로 변경하더라도
//SampleService 코드를 이용하는 코드를 수정할 일이 없으므로 보다 유연한 구조라고 말한다.
