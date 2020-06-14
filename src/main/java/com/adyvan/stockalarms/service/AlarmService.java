package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.model.Alarm;

import java.util.Set;

public interface AlarmService {

    Set<Alarm> getAllAlarmsForCurrentUser();

    void addAlarmForSymbol(String symbol);
}
