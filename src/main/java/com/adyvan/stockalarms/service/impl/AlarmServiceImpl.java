package com.adyvan.stockalarms.service.impl;

import com.adyvan.stockalarms.exceptions.StockAlarmException;
import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.repository.AlarmRepository;
import com.adyvan.stockalarms.repository.UserRepository;
import com.adyvan.stockalarms.service.AlarmService;
import com.adyvan.stockalarms.types.AlarmRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlarmServiceImpl implements AlarmService {

    private AlarmRepository alarmRepository;

    private UserRepository userRepository;

    private StockServiceImpl stockService;

    @Override
    public Set<Alarm> getAllAlarmsForCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);

        return alarmRepository.findByUser(user);
    }

    @Override
    public Alarm addAlarm(AlarmRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);

        Set<Alarm> alarms = alarmRepository.findByUser(user).stream()
                .filter(alarm -> alarm.getSymbol().equalsIgnoreCase(request.getSymbol()))
                .collect(Collectors.toSet());

        BigDecimal currentPrice = stockService.retrievePriceFromStock(request.getSymbol());
        Alarm alarm = new Alarm(user, request.getSymbol(), request.getThreshold(), currentPrice);
        if (alarms.isEmpty()) {
            alarms.add(alarm);
            user.setAlarms(alarms);
            userRepository.save(user);
        } else throw new StockAlarmException("Alarm for this symbol already exists!");

        return alarm;
    }
}
