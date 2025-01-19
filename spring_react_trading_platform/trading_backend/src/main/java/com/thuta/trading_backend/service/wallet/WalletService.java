package com.thuta.trading_backend.service.wallet;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Wallet;
import com.thuta.trading_backend.enums.ORDER_TYPE;
import com.thuta.trading_backend.repository.WalletRepository;

@Service
public class WalletService implements IWalletService {
    @Autowired
    private WalletRepository walletRepo;

    @Override
    public Wallet getUserWallet(User user) throws Exception {
        Wallet wallet = walletRepo.findByUserId(user.getId());
        if (wallet == null) {
            wallet = new Wallet();
            wallet.setUser(user);
            walletRepo.save(wallet);
        }
        return wallet;
    }

    @Override
    public Wallet addBalance(Wallet wallet, Long money) throws Exception {
        BigDecimal balanace = wallet.getBalance();
        if (balanace == null) {
            balanace = BigDecimal.ZERO;
        }
        BigDecimal newBalanace = balanace.add(BigDecimal.valueOf(money));
        wallet.setBalance(newBalanace);
        return walletRepo.save(wallet);
    }

    @Override
    public Wallet findWalletById(Long id) throws Exception {
        Optional<Wallet> wallet = walletRepo.findById(id);
        if (wallet.isEmpty()) {
            throw new Exception("Wallet not found with ID " + id);
        }
        return wallet.get();
    }

    @Override
    public Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception {
        if (amount == null || amount <= 0) {
            throw new Exception("Amount is required to transfer");
        }

        // get sender wallet
        Wallet senderWallet = getUserWallet(sender);

        // sender balance check
        BigDecimal senderBalance = senderWallet.getBalance() != null
                ? senderWallet.getBalance()
                : BigDecimal.ZERO;
        if (senderBalance.compareTo(BigDecimal.valueOf(amount)) < 0) {
            throw new Exception("Insufficient balance...");
        }

        // Deduct amount from sender's wallet
        senderWallet.setBalance(senderBalance.subtract(BigDecimal.valueOf(amount)));
        walletRepo.save(senderWallet);

        // Add amount to receiver's wallet
        BigDecimal receiverBalance = receiverWallet.getBalance() != null
                ? receiverWallet.getBalance()
                : BigDecimal.ZERO;
        receiverWallet.setBalance(receiverBalance.add(BigDecimal.valueOf(amount)));
        walletRepo.save(receiverWallet);

        return senderWallet;
    }

    @Override
    public Wallet payOrderPayment(Order order, User user) throws Exception {

        Wallet wallet = getUserWallet(user);

        if (order.getOrderType().equals(ORDER_TYPE.BUY)) {
            BigDecimal newBalance = wallet.getBalance().subtract(order.getPrice());
            if (newBalance.compareTo(order.getPrice()) < 0) {
                throw new Exception("Insufficient funds for this transaction");
            }
            wallet.setBalance(newBalance);
        } else {
            BigDecimal newBalance = wallet.getBalance().add(order.getPrice());
            wallet.setBalance(newBalance);
        }

        return walletRepo.save(wallet);
    }
}
