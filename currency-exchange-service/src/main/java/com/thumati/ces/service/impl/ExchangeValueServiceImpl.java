package com.thumati.ces.service.impl;

import com.thumati.ces.domain.ExchangeValue;
import com.thumati.ces.repository.IExchangeValueRepository;
import com.thumati.ces.service.IExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueServiceImpl implements IExchangeValueService {

    @Autowired
    private IExchangeValueRepository repository;

    @Override
    public com.thumati.ces.model.ExchangeValue exchangeValue(String from, String to) {
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        return domainToModel(exchangeValue);
    }

    private com.thumati.ces.model.ExchangeValue domainToModel(ExchangeValue exchangeValue){
        return new com.thumati.ces.model.ExchangeValue(exchangeValue.getId(), exchangeValue.getFrom(), exchangeValue.getTo(), exchangeValue.getConversionMultiple());
    }
}
