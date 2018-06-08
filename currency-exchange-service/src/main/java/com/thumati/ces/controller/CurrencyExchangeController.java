package com.thumati.ces.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thumati.ces.model.ExchangeValue;
import com.thumati.ces.service.IExchangeValueService;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private IExchangeValueService service;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
        //ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        ExchangeValue exchangeValue = service.exchangeValue(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("CES response {} ",exchangeValue);

        return exchangeValue;
    }
    
    @GetMapping("/currency-exchange-fault-tolerance/from/{from}/to/{to}")
    @HystrixCommand(fallbackMethod="getDefaultExchangevalue")
    public ExchangeValue getExchangeValueFaultTolerance(@PathVariable String from, @PathVariable String to){
        //ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
        ExchangeValue exchangeValue = service.exchangeValue(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("CES response {} ",exchangeValue);

        return exchangeValue;
    }
    
    public ExchangeValue getDefaultExchangevalue(String from, String to){
    	return new ExchangeValue(1000L, "USD", "INR", BigDecimal.valueOf(65));
    }
}
