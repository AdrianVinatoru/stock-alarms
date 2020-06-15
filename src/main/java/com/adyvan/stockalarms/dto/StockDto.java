package com.adyvan.stockalarms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class StockDto {

    @JsonProperty("Global Quote")
    public GlobalQuote globalQuote;

}
