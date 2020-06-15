package com.adyvan.stockalarms.rest;

import com.adyvan.stockalarms.dto.StockDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Component
@Slf4j
public class StockClient {
    @Value("${alpha.stock.alpha_url}")
    private String alpha_url;

    @Value("${alpha.stock.alpha_interval}")
    private String alpha_interval;

    @Value("${alpha.stock.apikey}")
    private String apikey;

    private final RestTemplate restTemplate;

    public StockClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public StockDto getStockBySymbol(String symbol) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(headers);

        alpha_url = this.alpha_url + symbol + alpha_interval + apikey;

        ResponseEntity<StockDto> responseEntity = restTemplate.exchange(
                alpha_url, HttpMethod.GET, request, StockDto.class
        );

        if (responseEntity.getStatusCode().value() != 200) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error while retrieving data from the AlphaVantage server");
        } else {
            return responseEntity.getBody();
        }
    }
}
