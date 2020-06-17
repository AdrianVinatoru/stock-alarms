package com.adyvan.stockalarms.service.impl;

import com.adyvan.stockalarms.dto.StockDto;
import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import com.adyvan.stockalarms.rest.StockRestClient;
import com.adyvan.stockalarms.service.AlarmService;
import com.adyvan.stockalarms.service.StockService;
import com.adyvan.stockalarms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private StockRestClient stockRestClient;

    private UserService userService;

   // private AlarmService alarmService;

    @Scheduled(cron = "0 */5 * ? * *") // every 5 minutes
    public void pollStocks() {
        userService.getAllUsers().stream()
                .map(user -> user.getAlarms())
                .flatMap(Set::stream)
                .forEach(alarm -> checkPriceModifications(alarm));
    }

    private void checkPriceModifications(Alarm alarm) {
        boolean exceeded = comparePrices(alarm);

        // TODO: if triggered, send email to the user
        if (exceeded) {
            updateInitialPriceInAlarm(alarm, retrievePriceFromStock(alarm.getSymbol()));
            sendEmail(alarm.getUser());
        }
    }

    private boolean comparePrices(Alarm alarm) {
        BigDecimal initialPrice = alarm.getInitialPrice();
        BigDecimal currentPrice = retrievePriceFromStock(alarm.getSymbol());
        float threshold = alarm.getThreshold();

        BigDecimal percentage = percentage(initialPrice, threshold);

        if (currentPrice.compareTo(initialPrice.add(percentage)) >= 1 ||
                currentPrice.compareTo(initialPrice.subtract(percentage)) <= 1) {
            return true;
        }

        return false;
    }


    private void updateInitialPriceInAlarm(Alarm alarm, BigDecimal newPrice) {
        // TODO: update Initial Price In The Alarm
        alarm.setInitialPrice(newPrice);
      //  alarmService.saveAlarm(alarm);
    }

    private void sendEmail(User user) {
        // TODO: send email to the user
        System.out.println("Email sent!");
    }

    public BigDecimal retrievePriceFromStock(String symbol) {
        StockDto stockDto = stockRestClient.getStockBySymbol(symbol);

        BigDecimal actualPrice = new BigDecimal(stockDto.getGlobalQuote().getPrice());

        return actualPrice;
    }

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private static BigDecimal percentage(BigDecimal base, float pct) {
        return base.multiply(BigDecimal.valueOf(pct)).divide(ONE_HUNDRED);
    }
}
