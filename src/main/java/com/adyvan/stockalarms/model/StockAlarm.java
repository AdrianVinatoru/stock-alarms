package com.adyvan.stockalarms.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ElementCollection(targetClass = String.class)
    private Set<String> symbols;
}
