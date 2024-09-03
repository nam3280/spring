package com.ssg.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Qualifier("basic")
//@Primary //우선 순위 부여
@Repository
//SampleDAOImpl에는 @Repository를 이용해서 해당 클래스의 객체를 스프링의 Bean으로 처리되도록 한다.
public class SampleDAOImpl implements SampleDAO{

}
