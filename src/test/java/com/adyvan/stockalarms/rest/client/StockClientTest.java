package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
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

    @Test
    public void getStockBySymbol() {
        StockDto stockDto = stockClient.getStockBySymbol("IBM");

        assertNotNull(stockDto);
    }

    @Test
    public void addAlarmForSymbol() {
        String symbol = "IBM";
        int threshold = 10;

        alarmService.addAlarmForSymbol(symbol, threshold);
    }
}
