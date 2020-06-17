package com.adyvan.stockalarms.types;

import com.adyvan.stockalarms.model.User;
import lombok.Data;

@Data
public class AlarmRequest {
    private Long id;

    private User user;

    private String symbol;

    private float threshold;

}