package com.thuta.trading_backend.service.watchlist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.WatchList;
import com.thuta.trading_backend.repository.WatchListRepository;

@Service
public class WatchListService implements IWatchListService {

    @Autowired
    private WatchListRepository watchListRepo;

    @Override
    public WatchList findUserWatchList(Long userId) throws Exception {
        Optional<WatchList> watchListOptional = Optional.of(watchListRepo.findByUserId(userId));
        if (watchListOptional.isEmpty()) {
            throw new Exception("WatchList not found with this userId " + userId);
        }
        return watchListOptional.get();
    }

    @Override
    public WatchList createWatchList(User user) {
        WatchList watchList = new WatchList();
        watchList.setUser(user);
        return watchListRepo.save(watchList);
    }

    @Override
    public WatchList findById(Long id) throws Exception {
        Optional<WatchList> watchListOptional = watchListRepo.findById(id);
        if (watchListOptional.isEmpty()) {
            throw new Exception("WatchList not found with this id " + id);
        }
        return watchListOptional.get();
    }

    @Override
    public Coin addItemToWatchList(Coin coin, User user) throws Exception {
        WatchList watchList = findUserWatchList(user.getId());

        if (watchList.getCoins().contains(coin)) {
            watchList.getCoins().remove(coin);
        } else {
            watchList.getCoins().add(coin);
        }
        watchListRepo.save(watchList);
        return coin;
    }

}