package com.mphase.stock.repository;

import com.mphase.stock.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
    public Stock findByOpenPrice(float openPrice);

}
