package com.dhani.stocks.mtfselltrade.services;

import com.opencsv.*;
import com.dhani.stocks.mtfselltrade.DTO.TradeCsvRow;
import com.dhani.stocks.mtfselltrade.projection.MtfSellTradeProjection;
import com.dhani.stocks.mtfselltrade.repositories.trades.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeReportService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${report.mail.to:stockteam@dhani.com}")
    private String mailTo;

    public File generateCsvFileOnly() throws Exception {
        List<MtfSellTradeProjection> trades = tradeRepository.findMtfSellTradesForToday();

        List<com.dhani.stocks.mtfselltrade.DTO.TradeCsvRow> rows = trades.stream().map(t -> {
            String symbol = t.getOrderParamsTradeSymbol();
            String[] parts = symbol != null ? symbol.split("-") : new String[]{"", ""};
            String scripCode = parts.length > 0 ? parts[0] : "";
            String series = parts.length > 1 ? parts[1] : "";

            return new TradeCsvRow(
                    t.getExchangeOrderId(),
                    null,
                    t.getOrderParamsAccountId(),
                    scripCode,
                    series,
                    t.getOrderParamsQuantity(),
                    null,
                    t.getOrderParamsProduct()
            );
        }).collect(Collectors.toList());  // ✅ Java 8 compatible

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName = "MTF_SELL_Invocation_" + date + ".csv";
        File file = new File(System.getProperty("java.io.tmpdir"), fileName);

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeNext(new String[]{"SETT_NO", "SETT_TYPE", "PARTY_CODE", "SCRIP_CODE", "SERIES", "QTY", "ISIN", "NRM/M"});
            for (TradeCsvRow row : rows) {
                writer.writeNext(new String[]{
                        row.getSettNo(),
                        row.getSettType(),
                        row.getPartyCode(),
                        row.getScripCode(),
                        row.getSeries(),
                        row.getQty() != null ? row.getQty().toString() : "0",
                        row.getIsin(),
                        row.getNrmOrM()
                });
            }
        }

        return file;
    }

    @Scheduled(cron = "0 5 16 * * *", zone = "Asia/Kolkata")
    public void generateAndSendCsvReport() throws Exception {
        List<MtfSellTradeProjection> trades = tradeRepository.findMtfSellTradesForToday();

        List<TradeCsvRow> rows = trades.stream().map(t -> {
            String symbol = t.getOrderParamsTradeSymbol();
            String[] parts = symbol != null ? symbol.split("-") : new String[]{"", ""};
            String scripCode = parts.length > 0 ? parts[0] : "";
            String series = parts.length > 1 ? parts[1] : "";

            return new TradeCsvRow(
                    t.getExchangeOrderId(),  // SETT_NO
                    null,                   // SETT_TYPE
                    t.getOrderParamsAccountId(), // PARTY_CODE
                    scripCode,              // SCRIP_CODE
                    series,                 // SERIES
                    t.getOrderParamsQuantity(), // QTY
                    null,                   // ISIN
                    t.getOrderParamsProduct()   // NRM/M
            );
        }).collect(Collectors.toList());  // ✅ Java 8 compatible

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName = "MTF_SELL_Invocation_" + date + ".csv";
        File file = new File(System.getProperty("java.io.tmpdir"), fileName);

        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeNext(new String[]{"SETT_NO", "SETT_TYPE", "PARTY_CODE", "SCRIP_CODE", "SERIES", "QTY", "ISIN", "NRM/M"});
            for (TradeCsvRow row : rows) {
                writer.writeNext(new String[]{
                        row.getSettNo(),
                        row.getSettType(),
                        row.getPartyCode(),
                        row.getScripCode(),
                        row.getSeries(),
                        row.getQty() != null ? row.getQty().toString() : "0",
                        row.getIsin(),
                        row.getNrmOrM()
                });
            }
        }

        sendMailWithAttachment(file);
    }

    private void sendMailWithAttachment(File file) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mailTo);
        helper.setSubject("Daily MTF SELL Report - " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        helper.setText("Please find attached the MTF SELL report.");
        helper.addAttachment(file.getName(), file);
        mailSender.send(message);
    }
}
