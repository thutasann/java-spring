package com.thuta.trading_backend.service.wallet;

import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Wallet;

public interface IWalletService {
    Wallet getUserWallet(User user) throws Exception;

    Wallet addBalance(Wallet wallet, Long money) throws Exception;

    Wallet findWalletById(Long id) throws Exception;

    Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;

    Wallet payOrderPayment(Order order, User user) throws Exception;
}
