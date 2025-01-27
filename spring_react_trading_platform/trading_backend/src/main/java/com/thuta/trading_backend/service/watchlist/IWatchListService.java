package com.thuta.trading_backend.service.watchlist;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.WatchList;

public interface IWatchListService {
    WatchList findUserWatchList(Long userId) throws Exception;

    WatchList createWatchList(User user);

    WatchList findById(Long id) throws Exception;

    Coin addItemToWatchList(Coin coin, User user) throws Exception;

}
