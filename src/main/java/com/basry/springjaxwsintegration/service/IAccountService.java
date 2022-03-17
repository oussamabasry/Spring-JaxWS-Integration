package com.basry.springjaxwsintegration.service;

import com.basry.springjaxwsintegration.entites.Account;

import java.util.List;

public interface IAccountService  {
    Account getAccount(Long id);
    List<Account> listAccounts();
    void pay (Long accountID, double amount);
    void withdraw(Long accountID, double amount);
    void transfer(Long accountID1, Long accountID2, double amount);
    Account save(Account account);
}
