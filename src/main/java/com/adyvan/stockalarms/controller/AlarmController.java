package com.adyvan.stockalarms.controller;

import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.service.AlarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/alarms")
public class AlarmController {

    @Autowired
    private AlarmServiceImpl alarmService;

    @GetMapping
    public Set<Alarm> getAlarms() {
        return alarmService.getAllAlarmsForCurrentUser();
    }

    @PutMapping("/{symbol}")
    public void addAlarmForSymbol(@PathVariable String symbol) {
        alarmService.addAlarmForSymbol(symbol);

    }

    @PostMapping("/{symbol}")
    public void addAlarmForSymbol2(@PathVariable String symbol) {
        alarmService.addAlarmForSymbol(symbol);

    }
}
