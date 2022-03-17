package com.basry.springjaxwsintegration.repositories;

import com.basry.springjaxwsintegration.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
