package com.thuta.trading_backend.service.asset;

import com.thuta.trading_backend.entity.Asset;

public interface IAssetService {
    Asset createAsset(Asset asset) throws Exception;

    Asset updateAsset(Long id, double quantity) throws Exception;

    void deleteAsset(Long id) throws Exception;
}
