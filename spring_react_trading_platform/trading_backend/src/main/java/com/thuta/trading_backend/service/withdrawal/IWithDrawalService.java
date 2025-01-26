package com.thuta.trading_backend.service.withdrawal;

import java.util.List;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Withdrawal;

public interface IWithDrawalService {
    Withdrawal requestWithdrawal(Long amount, User user);

    Withdrawal proceedWithWithdrawal(Long withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
