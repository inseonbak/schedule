package com.sparta.schedule.controller;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);
        // Memo Max ID Check
        Long maxId = scheduleList.size() > 0 ? Collections.max(scheduleList.keySet()) + 1 : 1;
        schedule.setId(maxId);

        //DB저장
        scheduleList.put(schedule.getId(), schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules() {
        //map to list
        List<ScheduleResponseDto> responseList = scheduleList.values().stream()
                .map(ScheduleResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        // 해당 스케쥴이 DB에 존재하는 지 확인
        if (scheduleList.containsKey(id)) {

            // 해당 스케쥴 가져오기
            Schedule schedule = scheduleList.get(id);

            //스케쥴 수정
            schedule.update(requestDto);
            return schedule.getId();
        } else {
            throw new IllegalArgumentException("선택한 스케쥴은 존재하지 않습니다.");
        }

    }

    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        // 해당 스케쥴이 DB에 존제하는지 확인
        if (scheduleList.containsKey(id)) {
            // 해당 메모가 DB에 존재하는지 확인
            scheduleList.remove(id);
            return id;

        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다");
        }
    }
}





