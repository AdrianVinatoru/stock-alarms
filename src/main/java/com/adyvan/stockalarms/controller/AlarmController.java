package com.adyvan.stockalarms.controller;

import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.service.impl.AlarmServiceImpl;
import com.adyvan.stockalarms.types.AlarmRequest;
import com.adyvan.stockalarms.types.GenericResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.httpclient.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/alarms")
@AllArgsConstructor
public class AlarmController {

    private AlarmServiceImpl alarmService;

    @GetMapping
    public ResponseEntity<GenericResponse> getAlarms() {
        Set<Alarm> alarmList = alarmService.getAllAlarmsForCurrentUser();

        GenericResponse response = GenericResponse.builder()
                .result(alarmList)
                .httpCode(HttpStatus.SC_OK)
                .httpMessage(HttpStatus.getStatusText(HttpStatus.SC_OK))
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> addAlarm(@RequestBody AlarmRequest alarmRequest) {
        Alarm alarm = alarmService.addAlarm(alarmRequest);

        GenericResponse response = GenericResponse.builder()
                .result(alarm)
                .httpCode(HttpStatus.SC_OK)
                .httpMessage(HttpStatus.getStatusText(HttpStatus.SC_OK))
                .build();

        return ResponseEntity.ok(response);
    }

}
