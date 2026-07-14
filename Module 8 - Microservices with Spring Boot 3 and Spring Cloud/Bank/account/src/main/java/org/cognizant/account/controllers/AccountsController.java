package org.cognizant.account.controllers;

import org.cognizant.account.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/accounts")
public class AccountsController {
    @GetMapping("/{number}")
    public Account getAccounts(@PathVariable String number) {
        return new Account(number, "savings", 234343.0);
    }
}
