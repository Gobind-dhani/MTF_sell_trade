package com.dhani.stocks.mtfselltrade.DTO;

public class TradeCsvRow {
    private String settNo;
    private String settType;     // null
    private String partyCode;
    private String scripCode;
    private String series;
    private Integer qty;
    private String isin;         // null
    private String nrmOrM;

    public TradeCsvRow(String settNo, String settType, String partyCode, String scripCode,
                       String series, Integer qty, String isin, String nrmOrM) {
        this.settNo = settNo;
        this.settType = settType;
        this.partyCode = partyCode;
        this.scripCode = scripCode;
        this.series = series;
        this.qty = qty;
        this.isin = isin;
        this.nrmOrM = nrmOrM;
    }

    // Getters
    public String getSettNo() { return settNo; }
    public String getSettType() { return settType; }
    public String getPartyCode() { return partyCode; }
    public String getScripCode() { return scripCode; }
    public String getSeries() { return series; }
    public Integer getQty() { return qty; }
    public String getIsin() { return isin; }
    public String getNrmOrM() { return nrmOrM; }
}
