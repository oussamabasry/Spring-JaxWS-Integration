package com.basry.springjaxwsintegration.service;

import com.basry.springjaxwsintegration.entites.Account;
import com.basry.springjaxwsintegration.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IAccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;

    public IAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void pay(Long accountID, double amount) {
        Account account = getAccount(accountID);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(Long accountID, double amount) {
        Account account = getAccount(accountID);
        if(account.getBalance() < amount) throw new RuntimeException("Insufficient balance");
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }


    @Override
    public void transfer(Long accountID1, Long accountID2, double amount) {
        withdraw(accountID1, amount);
        pay(accountID2, amount);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
