package com.mphase.stock.service.impl;

import com.mphase.stock.model.Stock;
import com.mphase.stock.repository.StockRepository;
import com.mphase.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    public StockServiceImpl() {
    }

    @Override
    public List<Stock> findAllStocks() {
        System.out.println(stockRepository.findAll());
        return stockRepository.findAll();
    }
}
