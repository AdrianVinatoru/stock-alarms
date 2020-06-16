package com.adyvan.stockalarms.service.impl;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.rest.StockRestClient;
import com.adyvan.stockalarms.service.StockService;
import com.adyvan.stockalarms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private StockRestClient stockRestClient;

    private UserService userService;

    public void pollStocks() {
        userService.getAllUsers().stream()
                .map(user -> user.getAlarms())
                .flatMap(Set::stream)
                .forEach(alarm -> checkPriceModifications(alarm));
    }

    private void checkPriceModifications(Alarm alarm) {
        // TODO: check the new price whit the alarm.getThreshold condition
        boolean exceeded = comparePrices(alarm.getInitialPrice(), retrievePriceFromStock(alarm.getSymbol()));

        // TODO: if triggered, send email to the user
        if (exceeded) sendEmail(alarm.getUser());
    }

    private boolean comparePrices(BigDecimal initialPrice, BigDecimal currentPrice) {
        // TODO: check the new price whit the alarm.getThreshold condition
        return true;
    }


    private void sendEmail(User user) {
        // TODO: send email to the user
    }

    public BigDecimal retrievePriceFromStock(String symbol) {
        StockDto stockDto = stockRestClient.getStockBySymbol(symbol);

        BigDecimal actualPrice = new BigDecimal(stockDto.getGlobalQuote().getPrice());

        return actualPrice;
    }
}
