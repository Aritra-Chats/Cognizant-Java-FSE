package org.cognizant.loan.controllers;

import org.cognizant.loan.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/loans")
public class LoanController {
    @GetMapping("/{number}")
    public Loan getLoans(@PathVariable String number) {
        return new Loan(number, "car", 400000.0, 3258.0, 18);
    }
}
