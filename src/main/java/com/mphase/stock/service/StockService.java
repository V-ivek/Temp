package com.mphase.stock.service;

import com.mphase.stock.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAllStocks();
}
