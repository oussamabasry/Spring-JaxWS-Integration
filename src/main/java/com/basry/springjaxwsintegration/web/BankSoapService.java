package com.basry.springjaxwsintegration.web;

import com.basry.springjaxwsintegration.entites.Account;
import com.basry.springjaxwsintegration.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "BankWS")
@Component
public class BankSoapService {
    @Autowired
    private IAccountService accountService;

    public BankSoapService(){}
    @WebMethod
    public Account getAccount(@WebParam(name = "accountID") Long id){
        return accountService.getAccount(id);
    }
    @WebMethod
    public List<Account> getAccounts(){
        return accountService.listAccounts();
    }
    @WebMethod
    public void payment(@WebParam(name = "accountID") Long id, @WebParam(name = "amount") double amount){
        accountService.pay(id, amount);
    }
    @WebMethod
    public void withdraw(@WebParam(name = "accountID") Long id,@WebParam(name = "amount") double amount){
        accountService.withdraw(id, amount);
    }
    @WebMethod
    public void transfer(@WebParam(name = "accountID1") Long account1, @WebParam(name = "accountID2") Long account2, @WebParam(name = "amount")double amount){
        accountService.transfer(account1,account2, amount);
    }
}
