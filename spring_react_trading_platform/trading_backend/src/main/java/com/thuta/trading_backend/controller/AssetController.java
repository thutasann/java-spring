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

import com.thuta.trading_backend.entity.Asset;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.asset.IAssetService;
import com.thuta.trading_backend.service.user.IUserService;

@RestController
@RequestMapping("${api.prefix}/assets")
public class AssetController {
    @Autowired
    private IAssetService assetService;

    @Autowired
    private IUserService userService;

    @GetMapping("/{assetId}")
    public ResponseEntity<DataResponse> getCoinsList(
            @PathVariable() Long assetId) {
        try {
            Asset asset = assetService.getAssetById(assetId);
            return ResponseEntity.ok(new DataResponse("get asset by Id", asset));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/coin/{coinId}/user")
    public ResponseEntity<DataResponse> getAssetByUserIdAndCoinId(
            @PathVariable() String coinId,
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Asset asset = assetService.findAssetByUserIdAndCoinId(user.getId(), coinId);
            return ResponseEntity.ok(new DataResponse("get asset by userId and coinId", asset));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/get")
    public ResponseEntity<DataResponse> getAssetsForUser(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            List<Asset> asset = assetService.getUserAssets(user.getId());
            return ResponseEntity.ok(new DataResponse("get assets for user", asset));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
