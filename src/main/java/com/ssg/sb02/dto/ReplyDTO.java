package com.ssg.sb02.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private Long rno;   //댓글의 고유값

    @NotNull
    private Long bno;   //게시물 번호를 통해 현재 댓글이 특정 게시물의 댓글임을 알 수 있도록 함.
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;
    @JsonFormat(pattern = "yyyy-MM-DD HH:mm:ss")
    private LocalDateTime regDate;
    @JsonIgnore
    private LocalDateTime modDate;
}
