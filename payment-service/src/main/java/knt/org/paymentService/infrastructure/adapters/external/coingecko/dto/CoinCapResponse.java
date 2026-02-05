package knt.org.paymentService.infrastructure.adapters.external.coingecko.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CoinCapResponse {

    public AssetData data;


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AssetData{
        @JsonProperty("changePercent24Hr")
        public BigDecimal change24hrs;
        @JsonProperty("priceUsd")
        public BigDecimal priceUSD;
        @JsonProperty("symbol")
        public  String symbol;
    }

}