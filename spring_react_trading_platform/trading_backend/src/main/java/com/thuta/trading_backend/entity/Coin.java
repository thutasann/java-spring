package com.thuta.trading_backend.entity;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Coin Entity
 */
@Entity
@Data
public class Coin {
    @Id
    private String id;

    private String symbol;

    private String name;

    private String image;

    @Column(name = "current_price")
    private Double currentPrice;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column(name = "market_cap_rank")
    private Integer marketCapRank;

    @Column(name = "fully_diluted_valuation")
    private Long fullyDilutedValuation;

    @Column(name = "total_volume")
    private Long totalVolume;

    @Column(name = "high_24h")
    private Double high24h;

    @Column(name = "low_24h")
    private Double low24h;

    @Column(name = "price_change_24h")
    private Double priceChange24h;

    @Column(name = "price_change_percentage_24h")
    private Double priceChangePercentage24h;

    @Column(name = "market_cap_change_24h")
    private Long marketCapChange24h;

    @Column(name = "market_cap_change_percentage_24h")
    private Double marketCapChangePercentage24h;

    @Column(name = "circulating_supply")
    private Double circulatingSupply;

    @Column(name = "total_supply")
    private Double totalSupply;

    @Column(name = "max_supply")
    private Double maxSupply;

    private Double ath;

    @Column(name = "ath_change_percentage")
    private Double athChangePercentage;

    @Column(name = "ath_date")
    private ZonedDateTime athDate;

    private Double atl;

    @Column(name = "atl_change_percentage")
    private Double atlChangePercentage;

    @Column(name = "atl_date")
    private ZonedDateTime atlDate;

    @Column(name = "roi")
    @JsonIgnore
    private String roi;

    @Column(name = "last_updated")
    private ZonedDateTime lastUpdated;
}
