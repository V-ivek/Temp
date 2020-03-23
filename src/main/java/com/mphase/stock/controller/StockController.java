package com.mphase.stock.controller;

import com.mphase.stock.model.Stock;
import com.mphase.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stock")
    public List<Stock> getAllStocks() {
        return stockService.findAllStocks();
    }
}
