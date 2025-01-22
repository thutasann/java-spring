package com.thuta.trading_backend.service.asset;

import java.util.List;

import com.thuta.trading_backend.entity.Asset;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.User;

public interface IAssetService {
    Asset createAsset(User user, Coin coin, double quantity) throws Exception;

    Asset getAssetById(Long assetId) throws Exception;

    Asset getAssetByUserIdAndId(Long userId, Long assetId) throws Exception;

    Asset updateAsset(Long id, double quantity) throws Exception;

    void deleteAsset(Long id) throws Exception;

    List<Asset> getUserAssets(Long userId);

    Asset findAssetByUserIdAndCoinId(Long userId, String coinId) throws Exception;

}
