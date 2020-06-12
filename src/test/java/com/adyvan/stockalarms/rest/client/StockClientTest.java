package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.rest.StockClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StockClientTest {

    @Autowired
    private StockClient stockClient;

    @Test
    public void getStockBySymbol() {
        StockDto stockDto = stockClient.getStockBySymbol("IBM");

        assertNotNull(stockDto);
    }

}
