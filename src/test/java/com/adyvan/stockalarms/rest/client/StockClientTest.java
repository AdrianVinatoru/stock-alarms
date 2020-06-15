package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.repository.UserRepository;
import com.adyvan.stockalarms.rest.StockClient;
import com.adyvan.stockalarms.service.AlarmServiceImpl;
import com.adyvan.stockalarms.types.AlarmRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StockClientTest {

    @Autowired
    private StockClient stockClient;

    @Autowired
    private AlarmServiceImpl alarmService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getStockBySymbol() {
        StockDto stockDto = stockClient.getStockBySymbol("IBM");

        assertNotNull(stockDto);
    }

/*    @Test
    public void addAlarmForSymbol() {
        String symbol = "IBM";
        int threshold = 10;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userRepository.findByEmail(currentPrincipalName);

        AlarmRequest alarm = new Alarm(user, symbol, threshold);

        alarmService.addAlarm(alarm);
    }*/
}
