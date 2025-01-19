package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.coin.ICoinService;

@RestController
@RequestMapping("${api.prefix}/coins")
public class CoinController {
    @Autowired
    private ICoinService coinService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/get")
    public ResponseEntity<DataResponse> getCoinsList(
            @RequestParam("page") int page) {
        try {
            List<Coin> coins = coinService.getCoinList(page);
            return ResponseEntity.ok(new DataResponse("coins list by market success", coins));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/{coinId}/chart")
    public ResponseEntity<DataResponse> getMarketChart(
            @PathVariable String coinId,
            @RequestParam("days") int days) {
        try {
            String response = coinService.getMarketChart(coinId, days);
            JsonNode jsonNode = objectMapper.readTree(response);
            return ResponseEntity.ok(new DataResponse("get market chart", jsonNode));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<DataResponse> searchCoin(
            @RequestParam("q") String keyword) {
        try {
            String response = coinService.searchCoin(keyword);
            JsonNode jsonNode = objectMapper.readTree(response);
            return ResponseEntity.ok(new DataResponse("serach coin", jsonNode));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/top50")
    public ResponseEntity<DataResponse> getTop50() {
        try {
            String response = coinService.getTop50CoinsByMarketCapRank();
            JsonNode jsonNode = objectMapper.readTree(response);
            return ResponseEntity.ok(new DataResponse("get top 50 coins by market cap rank", jsonNode));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/treading")
    public ResponseEntity<DataResponse> getTreading() {
        try {
            String response = coinService.getTreadingCoins();
            JsonNode jsonNode = objectMapper.readTree(response);
            return ResponseEntity.ok(new DataResponse("get trending coins", jsonNode));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/details/{coinId}")
    public ResponseEntity<DataResponse> getCoinDetail(
            @PathVariable String coinId) {
        try {
            String response = coinService.getCoinDetails(coinId);
            return ResponseEntity.ok(new DataResponse("get coin details", response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
