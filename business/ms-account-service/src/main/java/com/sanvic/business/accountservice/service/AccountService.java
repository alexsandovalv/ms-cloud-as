package com.sanvic.business.accountservice.service;

import com.sanvic.business.accountservice.model.Account;
import com.sanvic.business.accountservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account account) {
        return accountRepository.findById(id).map( accountExisted -> {
            accountExisted.setAccountName(account.getAccountName());
            accountExisted.setAccountType(account.getAccountType());
            accountExisted.setBalance(account.getBalance());
            accountExisted.setEstado(account.getEstado());
            accountExisted.setTipoDocumento(account.getTipoDocumento());
            return accountRepository.save(account);
        } ).orElse(null);
    }

    public boolean deleteAccount(Long id) {
        return accountRepository.findById(id).map(account -> {
            accountRepository.delete(account);
            return true;
        }).orElse(false);
    }

}
