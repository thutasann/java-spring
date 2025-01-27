package com.thuta.trading_backend.service.withdrawal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.entity.Withdrawal;
import com.thuta.trading_backend.enums.WITHDRAWAL_STATUS;
import com.thuta.trading_backend.repository.WithDrawalRepository;

@Service
public class WithdrawalService implements IWithDrawalService {
    @Autowired
    private WithDrawalRepository withDrawalRepo;

    @Override
    public Withdrawal requestWithdrawal(Long amount, User user) {
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(amount);
        withdrawal.setUser(user);
        withdrawal.setStatus(WITHDRAWAL_STATUS.PENDING);
        return withDrawalRepo.save(withdrawal);
    }

    @Override
    public Withdrawal proceedWithWithdrawal(Long withdrawalId, boolean accept) throws Exception {
        Optional<Withdrawal> withdrawal = withDrawalRepo.findById(withdrawalId);
        if (withdrawal.isEmpty()) {
            throw new Exception("withdrawal not found with this Id  " + withdrawalId);
        }
        Withdrawal withdrawal1 = withdrawal.get();
        withdrawal1.setDate(LocalDateTime.now());

        if (accept) {
            withdrawal1.setStatus(WITHDRAWAL_STATUS.SUCCESS);
        } else {
            withdrawal1.setStatus(WITHDRAWAL_STATUS.PENDING);
        }

        return withDrawalRepo.save(withdrawal1);
    }

    @Override
    public List<Withdrawal> getUsersWithdrawalHistory(User user) {
        return withDrawalRepo.findByUserId(user.getId());
    }

    @Override
    public List<Withdrawal> getAllWithdrawalRequest() {
        return withDrawalRepo.findAll();
    }
}
