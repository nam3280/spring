package com.ssg.springtodoservice.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
//서버 사이드 데이터 검증 : 스프링 MVC에서 파라미터는 검증 작업을 컨트롤러에서 진행
//@Valid, @BindingResult를 이용하여 처리
//hibernate-validate 라이브러리가 필요하다.
public class TodoDTO {
    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;

    @NotEmpty
    private String writer;

    private Boolean finished;
}