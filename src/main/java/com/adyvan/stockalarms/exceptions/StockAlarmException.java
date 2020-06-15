package com.adyvan.stockalarms.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockAlarmException extends RuntimeException {

    public StockAlarmException(String message) {
        super(message);
    }
}
