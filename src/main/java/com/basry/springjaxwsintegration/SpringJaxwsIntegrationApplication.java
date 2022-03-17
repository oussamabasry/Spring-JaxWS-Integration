package com.basry.springjaxwsintegration;

import com.basry.springjaxwsintegration.entites.Account;
import com.basry.springjaxwsintegration.repositories.AccountRepository;
import com.basry.springjaxwsintegration.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJaxwsIntegrationApplication implements CommandLineRunner {
   private IAccountService accountService;
    public SpringJaxwsIntegrationApplication(AccountRepository accountRepository, IAccountService accountService) {
        this.accountService = accountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJaxwsIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.save(new Account(null,9000,new Date(),true));
        accountService.save(new Account(null,12346,new Date(),true));
        accountService.pay(1L, 200);
        accountService.withdraw(2L, 500);
        System.out.println(accountService.getAccount(1L));
        System.out.println(accountService.getAccount(2L));

    }
}
