package com.thuta.trading_backend.service.coin;

import java.util.List;

import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.thuta.trading_backend.entity.Coin;

public interface ICoinService {
    List<Coin> getCoinList(int page)
            throws Exception, HttpClientErrorException, JsonMappingException, JsonProcessingException;

    String getMarketChart(String coinId, int days) throws Exception;

    String getCoinDetails(String coinId) throws Exception;

    Coin findById(String coinId) throws Exception;

    String searchCoin(String keyword);

    String getTop50CoinsByMarketCapRank(String market);

    String getTrendingCoins();
}
