package com.sparta.schedule.entity;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private long id;
    private String username;
    private String title;
    private String content;
    private String password;
    private String date;

    public Schedule(ScheduleRequestDto requestDto) {
        this.username=requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
    }
    public void update(ScheduleRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContents();
    }
}
