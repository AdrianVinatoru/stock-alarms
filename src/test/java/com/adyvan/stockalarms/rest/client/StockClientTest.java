package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.repository.UserRepository;
import com.adyvan.stockalarms.rest.StockRestClient;
import com.adyvan.stockalarms.service.impl.AlarmServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StockClientTest {

    @Autowired
    private StockRestClient stockRestClient;

    @Autowired
    private AlarmServiceImpl alarmService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getStockBySymbol() {
        StockDto stockDto = stockRestClient.getStockBySymbol("IBM");

        assertNotNull(stockDto);
    }
}
