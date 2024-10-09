package com.example.eventStore.controller;

import com.example.eventStore.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountEventController {
    private final AccountService accountService;

    public AccountEventController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("{accountId}/deposit")
    public String deposit(@PathVariable String accountId, @RequestParam BigDecimal amount) throws Exception {
        accountService.deposit(accountId, amount);
        return "Deposited " + amount + " to account " + accountId;
    }

    @PostMapping("{accountId}/withdraw")
    public String withdraw(@PathVariable String accountId, @RequestParam BigDecimal amount) throws Exception {
        accountService.withdraw(accountId, amount);
        return "Withdrawn " + amount + " from account " + accountId;
    }


}
