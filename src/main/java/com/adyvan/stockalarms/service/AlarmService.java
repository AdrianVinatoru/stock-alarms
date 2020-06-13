package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.repository.AlarmRepository;
import com.adyvan.stockalarms.rest.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AlarmService {
    @Autowired
    private StockClient stockClient;

    @Autowired
    private AlarmRepository alarmRepository;

    public Alarm addStockToWatchlist(String symbol) {
        StockDto stockDto = stockClient.getStockBySymbol(symbol);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        Optional<Alarm> alarmOptional = alarmRepository.findByUser(user);

/*        alarmOptional.ifPresent(
                alarm -> {
                    alarm.getSymbols().add(symbol);
                    stockAlarmRepository.save(alarm);
                }
        );*/

        alarmOptional
                .ifPresentOrElse(alarm -> {
                    alarm.setSymbol(symbol);
                    alarmRepository.save(alarm);
                }, () -> {
                    Alarm entity = new Alarm(user, symbol);
                    alarmRepository.save(entity);
                });

        return alarmOptional.get();
    }
}
