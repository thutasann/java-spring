package com.thuta.trading_backend.service.asset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.Asset;
import com.thuta.trading_backend.repository.AssetRepository;

@Service
public class AssetService implements IAssetService {

    @Autowired
    private AssetRepository assetRepo;

    @Override
    public Asset createAsset(Asset asset) {
        throw new UnsupportedOperationException("Unimplemented method 'createAsset'");
    }

    @Override
    public Asset updateAsset(Long id, double quantity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateAsset'");
    }

    @Override
    public void deleteAsset(Long id) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAsset'");
    }
}
