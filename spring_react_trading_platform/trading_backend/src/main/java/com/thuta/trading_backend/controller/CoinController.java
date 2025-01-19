package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.coin.ICoinService;

@RestController
@RequestMapping("${api.prefix}/coins")
public class CoinController {
    @Autowired
    private ICoinService coinService;

    @GetMapping("/get/{page}")
    public ResponseEntity<DataResponse> getUserProfile(
            @RequestHeader("Authorization") String jwt,
            @PathVariable int page) {
        try {
            List<Coin> coins = coinService.getCoinList(page);
            return ResponseEntity.ok(new DataResponse("coins list by market success", coins));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
