package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.types.AlarmRequest;

import java.util.Set;

public interface AlarmService {

    Set<Alarm> getAllAlarmsForCurrentUser();

    Alarm addAlarm(AlarmRequest request);

    Alarm saveAlarm(Alarm alarm);
}
