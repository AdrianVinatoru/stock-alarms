package com.adyvan.stockalarms.service;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.rest.StockClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class StockService {

    private StockClient stockClient;

    public BigDecimal retrievePriceFromStock(String symbol) {
        StockDto stockDto = stockClient.getStockBySymbol(symbol);

        BigDecimal openValue = new BigDecimal(stockDto.getGlobalQuote().getPrice());

        return openValue;
    }
}
