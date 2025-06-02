package com.dhani.stocks.mtfselltrade.controllers;

import com.dhani.stocks.mtfselltrade.services.TradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/api/trade-report")
public class TradeReportController {

    @Autowired
    private TradeReportService tradeReportService;

    @GetMapping("/generate-csv-only")
    public String generateCsvOnly() {
        try {
            File csvFile = tradeReportService.generateCsvFileOnly();
            return "CSV generated at: " + csvFile.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to generate CSV: " + e.getMessage();
        }
    }
}

