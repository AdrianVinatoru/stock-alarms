package com.adyvan.stockalarms.service;

import java.math.BigDecimal;

public interface StockService {

    BigDecimal retrievePriceFromStock(String symbol);
}
