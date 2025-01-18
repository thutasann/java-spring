package com.thuta.trading_backend.service.coin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.repository.CoinRepository;

@Service
public class CoinService implements ICoinService {
    @SuppressWarnings("unused")
    @Autowired
    private CoinRepository coinRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Coin> getCoinList(int page)
            throws Exception, HttpClientErrorException, JsonMappingException, JsonProcessingException {

        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=10&page=" + page;

        System.out.println("url ==> " + url);

        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            List<Coin> coninList = objectMapper.readValue(response.getBody(), new TypeReference<List<Coin>>() {
            });
            return coninList;
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
