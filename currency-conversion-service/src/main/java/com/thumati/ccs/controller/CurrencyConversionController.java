package com.thumati.ccs.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thumati.ccs.model.CurrencyConversion;
import com.thumati.ccs.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy exchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().
                                                                getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                                                                                    CurrencyConversion.class,
                                                                                    uriVariables);

        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getPort());

    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = exchangeServiceProxy.getExchangeValue(from, to);

        logger.info("CCS Response {} ",currencyConversion);

        return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(), quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getPort());

    }
    
    @GetMapping("/currency-converter-fault-tolerance/from/{from}/to/{to}/quantity/{quantity}")
    @HystrixCommand(fallbackMethod="getDefaultCurrencyConverter")
    public CurrencyConversion convertCurrencyFaultTolerance(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
    		logger.info("CCS Response {} ","hello CCS fault tolerance");
    		throw new RuntimeException("Not Available");
    }
    						  
    public CurrencyConversion getDefaultCurrencyConverter(String from, String to, BigDecimal quantity) {
    	logger.info("CCS Response {} ","hello CCS fallback method");
    	return new CurrencyConversion(10001L, "USD", "INR", BigDecimal.valueOf(65), BigDecimal.valueOf(1000), BigDecimal.valueOf(1000*65), 8100);
    }
    
}
