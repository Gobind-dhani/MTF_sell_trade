package com.dhani.stocks.mtfselltrade.model.trades;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "trades")
public class TradeTable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "order_params_exchange_seg")
    private String orderParamsExchangeSegment;
    @Column(name = "order_params_account_id")
    private String orderParamsAccountId;
    @Column(name = "order_params_order_duration")
    private String orderParamsOrdDuration;
    @Column(name = "order_params_customer_firm")
    private String orderParamsCustomerFirm;
    @Column(name = "order_params_product")
    private String orderParamsProduct;
    @Column(name = "order_params_order_type")
    private String orderParamsOrderType;
    @Column(name = "order_params_trade_symbol")
    private String orderParamsTrdSymbol;
    @Column(name = "order_params_transaction_type")
    private String orderParamsTransType;
    @Column(name = "order_params_gui_ord_id")
    private String orderParamsGuiOrdId;
    @Column(name = "order_params_gui_org_ord_id")
    private String orderParamsGuiOrgOrdId;
    @Column(name = "order_params_strategy_code")
    private String orderParamsStrategyCode;
    @Column(name = "order_params_warehouse_loc")
    private String orderParamsWarehouseLoc;
    @Column(name = "order_params_price")
    private double orderParamsPrice;
    @Column(name = "order_params_trigger_price")
    private double orderParamsTriggerPrice;
    @Column(name = "order_params_quantity")
    private Long orderParamsQuantity;
    @Column(name = "order_params_disc_quantity")
    private Long orderParamsDiscQuantity;
    @Column(name = "order_params_user_id")
    private String orderParamsUserId;
    @Column(name = "order_params_valid_date")
    private LocalDateTime orderParamsValidDate;
    @Column(name = "order_params_price_basis")
    private String orderParamsPriceBasis;
    @Column(name = "order_params_tick_count_down")
    private int orderParamsTickCountDown;
    @Column(name = "order_params_tick_count_up")
    private int orderParamsTickCountUp;
    @Column(name = "order_params_symbol")
    private String orderParamsSymbol;
    @Column(name = "order_params_trailing_ticks")
    private int orderParamsTrailingTicks;
    @Column(name = "order_params_market_protection")
    private String orderParamsMarketProtection;
    @Column(name = "order_params_exch_algo_id")
    private String orderParamsExchAlgoId;
    @Column(name = "order_params_exchange_algo_seq_nm")
    private String orderParamsExchAlgoSeqNm;
    @Column(name = "order_params_is_amo")
    private String orderParamsIsAMO;
    @Column(name = "order_params_vendor_code")
    private String orderParamsVendorCode;
    @Column(name = "order_params_order_source")
    private String orderParamsOrderSource;
    @Column(name = "order_params_sip_seq_num")
    private String orderParamsSipSeqNum;
    @Column(name = "order_params_quantity_type")
    private String orderParamsQuantityType;
    @Column(name = "order_params_value")
    private String orderParamsValue;
    @Column(name = "order_params_start_date")
    private LocalDateTime orderParamsStartDate;
    @Column(name = "order_params_tennure")
    private String orderParamsTennure;
    @Column(name = "order_params_tm_freq")
    private String orderParamsTmFreq;
    @Column(name = "order_params_broker")
    private String orderParamsBroker;
    @Column(name = "order_params_branch_id")
    private String orderParamsBranchId;
    @Column(name = "order_params_date")
    private LocalDateTime orderParamsDate;
    @Column(name = "order_params_period_time")
    private LocalDateTime orderParamsPeriodTime;
    @Column(name = "order_params_status")
    private String orderParamsStatus;
    @Column(name = "order_params_trigger_id")
    private String orderParamsTriggerId;
    @Column(name = "order_params_ord_init_status")
    private String orderParamsOrdInitStatus;
    @Column(name = "order_params_user_tag")
    private String orderParamsUserTag;
    @Column(name = "order_params_unique_code")
    private String orderParamsUniqueCode;
    @Column(name = "order_params_comments")
    private String orderParamsComments;
    @Column(name = "order_params_exchange_algo_category")
    private String orderParamsExchangeAlgoCategory;
    @Column(name = "order_params_exchange")
    private String orderParamsExchange;
    @Column(name = "order_params_criteria_attribute")
    private String orderParamsCriteriaAttribute;
    @Column(name = "order_params_user_msg")
    private String orderParamsUserMsg;
    @Column(name = "order_params_gui_validation")
    private String orderParamsGuiValidation;
    @Column(name = "order_params_original_price_type")
    private String orderParamsOriginalPriceType;
    @Column(name = "order_params_order_generation_type")
    private String orderParamsOrderGenerationType;
    @Column(name = "order_params_default_date_validity")
    private LocalDateTime orderParamsDefaultDateValidity;
    @Column(name = "order_params_cancelled_size")
    private String orderParamsCancelledSize;
    @Column(name = "order_params_rejected_size")
    private String orderParamsRejectedSize;
    @Column(name = "nest_order_number")
    private String nestOrdNum;
    @Column(name = "avg_price")
    private double avgPrice;
    @Column(name = "filled_shares")
    private Long filledShares;
    @Column(name = "unfilled_size")
    private Long unfilledSize;
    @Column(name = "req_id")
    private String reqId;
    @Column(name = "exchange_order_id")
    private String exchangeOrdId;
    @Column(name = "text")
    private String text;
    @Column(name = "status")
    private String status;
    @Column(name = "order_status")
    private String ordStatus;
    @Column(name = "nest_update_time")
    private LocalDateTime nestUpdateTime; // Changed to String to handle complex date-time format
    @Column(name = "exchange_time")
    private LocalDateTime exchangeTime; // Changed to String to handle complex date-time format
    @Column(name = "exchange_order_update_time")
    private LocalDateTime exchangeOrdUpdateTime; // Changed to String to handle complex date-time format
    @Column(name = "user_id")
    private String userId;
    @Column(name = "modified_info")
    private String modifiedInfo;
    @Column(name = "cancelled_info")
    private String cancelledInfo;
    @Column(name = "report")
    private String report;
    @Column(name = "market_protection")
    private String marketProtection;
    @Column(name = "exchange_algo_id")
    private String exchangeAlgoId;
    @Column(name = "exchange_algo_seq_nm")
    private String exchangeAlgoSeqNm;
    @Column(name = "is_amo")
    private String isAMO;
    @Column(name = "syom_order_id")
    private String syomOrderId;
    @Column(name = "order_source")
    private String orderSource;
    @Column(name = "tick_count_down")
    private int tickCountDown;
    @Column(name = "tick_count_up")
    private int tickCountUp;
    @Column(name = "user_msg")
    private String userMsg;
    @Column(name = "since_boe")
    private Long sinceBOE;
    @Column(name = "usecs")
    private Long uSecs;
    @Column(name = "fill_id")
    private Long fillId;
    @Column(name = "custom_text_login")
    private String customTextLogin;
    @Column(name = "order_criteria")
    private String orderCriteria;
    @Column(name = "order_user_msg")
    private String orderUserMsg;
    @Column(name = "modified_user")
    private String modifiedUser;
    @Column(name = "sip_sequence_num")
    private String sipSequenceNum;
    @Column(name = "last_activity_ref_time")
    private String lastActivityRefTime;
    @Column(name = "response")
    private String response;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false,insertable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at",updatable = false,insertable = false)
    private LocalDateTime updatedAt;
}
