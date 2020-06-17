package com.adyvan.stockalarms.rest.client;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.rest.StockRestClient;
import com.adyvan.stockalarms.service.StockService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StockClientTest {

    @Autowired
    private StockRestClient stockRestClient;

    @Autowired
    private StockService stockService;

    @Test
    public void getStockBySymbol() {
        StockDto stockDto = stockRestClient.getStockBySymbol("IBM");

        assertNotNull(stockDto);
    }

    @Test
    public void testPollStocks() {
        stockService.pollStocks();
    }
}
