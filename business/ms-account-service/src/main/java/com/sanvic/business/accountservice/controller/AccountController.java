package com.sanvic.business.accountservice.controller;

import com.sanvic.business.accountservice.model.Account;
import com.sanvic.business.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
        return Optional.of(ResponseEntity.ok(accountService.getAccountById(id)))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return Optional.ofNullable(accountService.getAccountById(account.getId()))
                .map(accountExists -> ResponseEntity.status(HttpStatus.CONFLICT).<Account>build())
                .orElse(ResponseEntity.ok(accountService.createAccount(account)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
        return Optional.ofNullable(accountService.updateAccount(id, account))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id) {
        return accountService.deleteAccount(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
