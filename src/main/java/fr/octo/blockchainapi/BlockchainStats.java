package fr.octo.blockchainapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BlockchainStats {

    @JsonProperty("market_price_usd")
    private BigDecimal marketPriceBitcoinInUSD;

    @JsonProperty("timestamp")
    private Long dateLastUpdate;

    public BigDecimal getMarketPriceBitcoinInUSD() {
        return marketPriceBitcoinInUSD;
    }

    public void setMarketPriceBitcoinInUSD(BigDecimal marketPriceBitcoinInUSD) {
        this.marketPriceBitcoinInUSD = marketPriceBitcoinInUSD;
    }

    public Long getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(Long dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

}
