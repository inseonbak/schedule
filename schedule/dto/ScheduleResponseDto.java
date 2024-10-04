package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private long id;
    private String username;
    private String title;
    private String contents;
    private String date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title=schedule.getTitle();
        this.contents=schedule.getContent();
        this.username=schedule.getUsername();
        this.date=schedule.getDate();
    }

}
