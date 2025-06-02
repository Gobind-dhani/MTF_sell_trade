package com.dhani.stocks.mtfselltrade.controllers;

import com.dhani.stocks.mtfselltrade.services.TradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/generate-and-mail")
    public ResponseEntity<String> generateAndSendCsvWithMail() {
        try {
            tradeReportService.generateAndSendCsvReport();
            return ResponseEntity.ok("CSV generated and email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to generate/send CSV email: " + e.getMessage());
        }
    }
}

