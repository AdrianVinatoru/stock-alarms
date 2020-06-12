package com.adyvan.stockalarms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@Getter
public class StockDto {
    @JsonProperty("Time Series (5min)")
    private Map<String, StockEntryDto> stockHistory;

/*    public Map<String, StockEntryDto> getStockHistory() {
        return stockHistory;*/
}
