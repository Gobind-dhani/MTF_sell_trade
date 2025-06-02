package com.dhani.stocks.mtfselltrade.repositories.trades;


import com.dhani.stocks.mtfselltrade.model.trades.TradeTable;
import com.dhani.stocks.mtfselltrade.projection.MtfSellTradeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TradeRepository extends JpaRepository<TradeTable, Long> {

    @Query(value = "SELECT "
            + "t.exchange_order_id, "
            + "t.order_params_account_id, "
            + "t.order_params_trade_symbol, "
            + "t.order_params_quantity, "
            + "t.order_params_product "
            + "FROM trade_feed.trades t "
            + "WHERE t.order_params_exchange_seg = 'nse_cm' "
            + "LIMIT 1000",
            nativeQuery = true)

    List<MtfSellTradeProjection> findMtfSellTradesForToday();
}
