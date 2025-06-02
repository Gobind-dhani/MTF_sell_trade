package com.dhani.stocks.mtfselltrade.projection;

public interface MtfSellTradeProjection {
    String getOrderParamsTradeSymbol();
    String getExchangeOrderId();
    String getOrderParamsAccountId();
    Integer getOrderParamsQuantity();
    String getOrderParamsProduct();
}
