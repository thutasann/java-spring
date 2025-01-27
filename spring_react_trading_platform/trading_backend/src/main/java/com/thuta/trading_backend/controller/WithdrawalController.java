package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Wallet;
import com.thuta.trading_backend.entity.Withdrawal;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.user.IUserService;
import com.thuta.trading_backend.service.wallet.IWalletService;
import com.thuta.trading_backend.service.wallet_transaction.IWalletTransactionService;
import com.thuta.trading_backend.service.withdrawal.IWithDrawalService;

@Controller
@RequestMapping("${api.prefix}/withdrawal")
public class WithdrawalController {
    @Autowired
    private IWithDrawalService withDrawalService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IWalletService walletService;

    @SuppressWarnings("unused")
    @Autowired
    private IWalletTransactionService walletTransactionService;

    @PostMapping("/{amount}")
    public ResponseEntity<DataResponse> withdrawalRequest(
            @PathVariable() Long amount,
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Wallet userWallet = walletService.getUserWallet(user);

            Withdrawal withdrawal = withDrawalService.requestWithdrawal(amount, user);
            walletService.addBalance(userWallet, -withdrawal.getAmount());

            // TODO: wallet transaction service -> createTransaction

            return ResponseEntity.ok(new DataResponse("withdrawal request success", withdrawal));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    /**
     * Admin Route to Proceed Withdrawal
     */
    @PatchMapping("/admin/withdrawal/{id}/proceed/{accept}")
    public ResponseEntity<DataResponse> proceedWithdrawal(
            @PathVariable Long id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            Withdrawal withdrawal = withDrawalService.proceedWithWithdrawal(id, accept);

            Wallet userWallet = walletService.getUserWallet(user);

            if (!accept) {
                walletService.addBalance(userWallet, withdrawal.getAmount());
            }

            return ResponseEntity.ok(new DataResponse("withdrawal proceed success", withdrawal));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/history")
    public ResponseEntity<DataResponse> getWithdrawalHistory(
            @PathVariable Long id,
            @PathVariable boolean accept,
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            List<Withdrawal> withdrawals = withDrawalService.getUsersWithdrawalHistory(user);

            return ResponseEntity.ok(new DataResponse("withdrawals history success", withdrawals));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @GetMapping("/admin/requests")
    public ResponseEntity<DataResponse> getAllWithdrawalRequest() {
        try {
            List<Withdrawal> withdrawals = withDrawalService.getAllWithdrawalRequest();
            return ResponseEntity.ok(new DataResponse("get all withdrwals requests success", withdrawals));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
