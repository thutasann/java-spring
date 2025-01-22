package com.thuta.trading_backend.service.asset;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.Asset;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.repository.AssetRepository;

@Service
public class AssetService implements IAssetService {

    @Autowired
    private AssetRepository assetRepo;

    @Override
    public Asset createAsset(User user, Coin coin, double quantity) {
        Asset asset = new Asset();
        asset.setUser(user);
        asset.setCoin(coin);
        asset.setQuantity(quantity);
        asset.setBuyPrice(coin.getCurrentPrice());
        return assetRepo.save(asset);
    }

    @Override
    public Asset updateAsset(Long id, double quantity) throws Exception {
        Asset oldAsset = this.getAssetById(id);
        oldAsset.setQuantity(quantity + oldAsset.getQuantity());
        return assetRepo.save(oldAsset);
    }

    @Override
    public void deleteAsset(Long id) throws Exception {
        assetRepo.deleteById(id);
    }

    @Override
    public Asset getAssetById(Long assetId) throws Exception {
        Optional<Asset> asset = assetRepo.findById(assetId);
        if (asset.isEmpty()) {
            throw new Exception("Asset not found with this Id " + assetId);
        }
        return asset.get();
    }

    @Override
    public Asset getAssetByUserIdAndId(Long userId, Long assetId) throws Exception {
        return null;
    }

    @Override
    public List<Asset> getUserAssets(Long userId) {
        return assetRepo.findByUserId(userId);
    }

    @Override
    public Asset findAssetByUserIdAndCoinId(Long userId, String coinId) throws Exception {
        return assetRepo.findByUserIdAndCoinId(userId, coinId);
    }
}
