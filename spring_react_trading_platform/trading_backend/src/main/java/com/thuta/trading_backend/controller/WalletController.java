package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.PaymentOrder;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Wallet;
import com.thuta.trading_backend.entity.WalletTransaction;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.order.IOrderService;
import com.thuta.trading_backend.service.payment_order.IPaymentOrderService;
import com.thuta.trading_backend.service.user.IUserService;
import com.thuta.trading_backend.service.wallet.IWalletService;

@RestController
@RequestMapping("${api.prefix}/wallet")
public class WalletController {
    @Autowired
    private IWalletService walletService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPaymentOrderService paymentOrderService;

    @GetMapping("/get")
    public ResponseEntity<DataResponse> getUserWallet(
            @RequestHeader("Authorization") String jwt) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Wallet wallet = walletService.getUserWallet(user);

            return ResponseEntity.ok(new DataResponse("get wallet by user", wallet));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PostMapping("/add-balance")
    public ResponseEntity<DataResponse> addBalance(
            @RequestHeader("Authorization") String jwt,
            @RequestParam Long balance,
            @RequestParam Long walletId) {
        try {
            Wallet wallet = walletService.findWalletById(walletId);
            Wallet response = walletService.addBalance(wallet, balance);

            return ResponseEntity.ok(new DataResponse("add balance", response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PutMapping("/transfer")
    public ResponseEntity<DataResponse> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @RequestParam Long walletId,
            @RequestBody WalletTransaction walletTransaction) {
        try {
            User senderUser = userService.findUserProfileByJwt(jwt);

            Wallet receiverWallet = walletService.findWalletById(walletId);

            Wallet wallet = walletService.walletToWalletTransfer(
                    senderUser, receiverWallet,
                    walletTransaction.getAmount());

            return ResponseEntity.ok(new DataResponse("wallet to wallet transfer", wallet));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PutMapping("/order/{orderId}/pay")
    public ResponseEntity<DataResponse> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            Order order = orderService.getOrderById(orderId);

            Wallet wallet = walletService.payOrderPayment(order, user);

            return ResponseEntity.ok(new DataResponse("pay order payment", wallet));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }

    @PutMapping("/order/deposit")
    public ResponseEntity<DataResponse> addBalanceToWallet(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(name="order_id") Long orderId,
            @RequestParam(name="payment_id") String paymentId) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            Wallet wallet = walletService.getUserWallet(user);

            PaymentOrder order = paymentOrderService.getPaymentOrderById(orderId);

            Boolean status = paymentOrderService.proceedPaymentOrder(order, paymentId);

            if(status) {
                wallet = walletService.addBalance(wallet, order.getAmount());
            }

            return ResponseEntity.ok(new DataResponse("add balance to wallet", wallet));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", e.getMessage()));
        }
    }
}
