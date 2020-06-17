package com.adyvan.stockalarms.service;

import java.math.BigDecimal;

public interface StockService {

    void pollStocks();

    BigDecimal retrievePriceFromStock(String symbol);

}
