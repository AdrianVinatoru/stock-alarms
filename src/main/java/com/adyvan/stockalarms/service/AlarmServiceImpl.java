package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.repository.AlarmRepository;
import com.adyvan.stockalarms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<Alarm> getAllAlarmsForCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);

        return alarmRepository.findByUser(user);
    }

    public void addAlarmForSymbol(String symbol) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);

        Set<Alarm> alarms = alarmRepository.findByUser(user).stream()
                .filter(alarm -> alarm.getSymbol().equalsIgnoreCase(symbol))
                .collect(Collectors.toSet());

        if (alarms.isEmpty()) {
            alarms.add(new Alarm(user, symbol));
            user.setAlarms(alarms);
            userRepository.save(user);
        } else throw new  RuntimeException("Alarm for this symbol already exists!");
    }
}
