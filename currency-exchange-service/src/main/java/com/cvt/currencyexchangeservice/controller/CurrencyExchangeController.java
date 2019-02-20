package com.cvt.currencyexchangeservice.controller;

import com.cvt.currencyexchangeservice.exchange.CurrencyExchange;
import com.cvt.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange currencyExchangeFromTo(@PathVariable String from, @PathVariable String to){
        int port=Integer.parseInt(environment.getProperty("local.server.port"));
        CurrencyExchange exchange=currencyExchangeRepository.findByFromAndTo(from,to);
        //return new CurrencyExchange(1L,"USD","INR", BigDecimal.valueOf(65),port);
        exchange.setPort(port);
        logger.info("{}",exchange);
        return exchange;
    }
}
