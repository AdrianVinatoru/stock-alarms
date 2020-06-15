package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.repository.UserRepository;
import com.adyvan.stockalarms.rest.StockClient;
import com.adyvan.stockalarms.service.AlarmServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
