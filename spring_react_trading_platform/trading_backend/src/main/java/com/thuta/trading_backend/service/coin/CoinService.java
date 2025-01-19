package com.thuta.trading_backend.service.coin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.repository.CoinRepository;
import com.thuta.trading_backend.util.RestTemplateUtil;

@Service
public class CoinService implements ICoinService {
    @SuppressWarnings("unused")
    @Autowired
    private CoinRepository coinRepo;

    @Override
    public List<Coin> getCoinList(int page)
            throws Exception, HttpClientErrorException, JsonMappingException, JsonProcessingException {

        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=10&page=" + page;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            return RestTemplateUtil.makeRequest(
                    url,
                    HttpMethod.GET,
                    null,
                    headers,
                    new TypeReference<List<Coin>>() {
                    });

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at getting coins list " + e.getMessage());
        }
    }

    @Override
    public String getMarketChart(String coinId, int days) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getMarketChart'");
    }

    @Override
    public String getCoinDetails(String coinId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getCoinDetails'");
    }

    @Override
    public Coin findById(String coinId) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public String searchCoin(String keyword) {
        throw new UnsupportedOperationException("Unimplemented method 'searchCoin'");
    }

    @Override
    public String getTop50CoinsByMarketCapRank(String market) {
        throw new UnsupportedOperationException("Unimplemented method 'getTop50CoinsByMarketCapRank'");
    }

    @Override
    public String getTrendingCoins() {
        throw new UnsupportedOperationException("Unimplemented method 'getTrendingCoins'");
    }

}
