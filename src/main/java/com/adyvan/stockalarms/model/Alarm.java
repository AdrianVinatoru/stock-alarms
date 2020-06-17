package com.adyvan.stockalarms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private String symbol;

    private float threshold;

    @Digits(integer=5, fraction=2)
    @Column(name = "current_open_value")
    private BigDecimal initialPrice;


    public Alarm(User user, String symbol, float threshold, BigDecimal initialPrice) {
        this.user = user;
        this.symbol = symbol;
        this.threshold = threshold;
        this.initialPrice = initialPrice;
    }
}
