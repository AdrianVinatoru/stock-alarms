package com.adyvan.stockalarms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GlobalQuote {

    @JsonProperty("01. symbol")
    private String symbol;

    @JsonProperty("02. open")
    private String open;

    @JsonProperty("03. high")
    private String high;

    @JsonProperty("04. low")
    private String low;

    @JsonProperty("05. price")
    private String price;

    @JsonProperty("06. volume")
    private String volume;

    @JsonProperty("09. change")
    private String change;
}
