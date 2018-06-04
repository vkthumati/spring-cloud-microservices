package com.thumati.ces.repository;

import com.thumati.ces.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
    public ExchangeValue findByFromAndTo(String from, String to);
}
