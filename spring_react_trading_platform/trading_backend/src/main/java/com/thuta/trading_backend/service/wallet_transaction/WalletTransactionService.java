package com.thuta.trading_backend.service.wallet_transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.repository.WalletTransactionRepository;

@Service
public class WalletTransactionService implements IWalletTransactionService {
    @Autowired
    private WalletTransactionRepository walletTransactionRepo;
}
