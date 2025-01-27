package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.WatchList;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.coin.ICoinService;
import com.thuta.trading_backend.service.user.IUserService;
import com.thuta.trading_backend.service.watchlist.IWatchListService;

@RestController
@RequestMapping("${api.prefix}/watchlist")
public class WatchListCOntroller {
    @Autowired
    private IWatchListService watchListService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICoinService coinService;

    @GetMapping("/user")
    public ResponseEntity<DataResponse> getUserWatchList(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            WatchList watchList = watchListService.findUserWatchList(user.getId());

            return ResponseEntity.ok(new DataResponse("get user watchlist success", watchList));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DataResponse> createWatchList(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            WatchList watchList = watchListService.createWatchList(user);
            return ResponseEntity.ok(new DataResponse("create watchlist success", watchList));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/{watchListId}")
    public ResponseEntity<DataResponse> getWatchListById(
            @PathVariable Long watchListId,
            @RequestHeader("Authorization") String jwt) {
        try {
            WatchList watchList = watchListService.findById(watchListId);
            return ResponseEntity.ok(new DataResponse("get watchlist by Id success", watchList));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PatchMapping("/add/coin/{coinId}")
    public ResponseEntity<DataResponse> addItemToWatchList(
            @PathVariable String coinId,
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Coin foundCoin = coinService.findById(coinId);
            Coin coin = watchListService.addItemToWatchList(foundCoin, user);
            return ResponseEntity.ok(new DataResponse("add coin to watchlist success", coin));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
