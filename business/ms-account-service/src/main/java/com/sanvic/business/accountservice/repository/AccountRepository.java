package com.sanvic.business.accountservice.repository;

import com.sanvic.business.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
