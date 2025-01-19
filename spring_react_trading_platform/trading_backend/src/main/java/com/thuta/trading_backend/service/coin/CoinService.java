package com.thuta.trading_backend.service.coin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.repository.CoinRepository;
import com.thuta.trading_backend.util.RestTemplateUtil;

@Service
public class CoinService implements ICoinService {
    @Autowired
    private CoinRepository coinRepo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Coin> getCoinList(int page) throws Exception {
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
        String url = "https://api.coingecko.com/api/v3/coins/" + coinId
                + "/market_chart?vs_currency=usd&days=" + days;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            return RestTemplateUtil.makeRequest(
                    url,
                    HttpMethod.GET,
                    null,
                    headers,
                    new TypeReference<String>() {
                    });

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at getting Market Chart " + e.getMessage());
        }
    }

    @Override
    public String getCoinDetails(String coinId) throws Exception {
        String url = "https://api.coingecko.com/api/v3/coins/" + coinId;

        RestTemplate restTemplate = new RestTemplate();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            JsonNode jsonNode = objectMapper.readTree(response.getBody());

            Coin coin = new Coin();
            coin.setId(jsonNode.get("id").asText());
            coin.setName(jsonNode.get("name").asText());
            coin.setSymbol(jsonNode.get("symbol").asText());
            coin.setImage(jsonNode.get("image").get("large").asText());

            JsonNode marketData = jsonNode.get("market_data");

            coin.setCurrentPrice(marketData.get("current_price").get("usd").asDouble());
            coin.setMarketCap(marketData.get("market_cap").get("usd").asLong());
            coin.setMarketCapRank(marketData.get("market_cap_rank").asInt());
            coin.setTotalVolume(marketData.get("total_volume").get("usd").asLong());
            coin.setHigh24h(marketData.get("high24h").get("usd").asDouble());
            coin.setLow24h(marketData.get("low24h").get("usd").asDouble());
            coin.setPriceChange24h(marketData.get("price_change_24h").get("usd").asDouble());
            coin.setPriceChangePercentage24h(marketData.get("price_change_2_24h").get("usd").asDouble());
            coin.setMarketCapChange24h(marketData.get("market_cap_change_24h").asLong());
            coin.setMarketCapChangePercentage24h(marketData.get("market_cap_change_per_24h").asDouble());
            coin.setTotalSupply(marketData.get("total_supply").get("usd").asDouble());
            coinRepo.save(coin);

            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at Getting Coin Details " + e.getMessage());
        }
    }

    @Override
    public Coin findById(String coinId) throws Exception {
        Optional<Coin> coin = coinRepo.findById(coinId);
        if (coin.isEmpty()) {
            throw new Exception("Coin not found");
        }
        return coin.get();
    }

    @Override
    public String searchCoin(String keyword) throws Exception {
        String url = "https://api.coingecko.com/api/v3/search?query=" + keyword;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            return RestTemplateUtil.makeRequest(
                    url,
                    HttpMethod.GET,
                    null,
                    headers,
                    new TypeReference<String>() {
                    });

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at Searching coin " + e.getMessage());
        }
    }

    @Override
    public String getTop50CoinsByMarketCapRank() throws Exception {
        String url = "https://api.coingecko.com/api/v3/coins/markets/vs_currency=usd&per_page=50&page=1";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            return RestTemplateUtil.makeRequest(
                    url,
                    HttpMethod.GET,
                    null,
                    headers,
                    new TypeReference<String>() {
                    });

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at get Top50Coins ByMarketCapRank " + e.getMessage());
        }
    }

    @Override
    public String getTreadingCoins() throws Exception {
        String url = "https://api.coingecko.com/api/v3/search/treading";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");

            return RestTemplateUtil.makeRequest(
                    url,
                    HttpMethod.GET,
                    null,
                    headers,
                    new TypeReference<String>() {
                    });

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw new Exception("something went wrong at Get Trending Coins " + e.getMessage());
        }
    }
}
