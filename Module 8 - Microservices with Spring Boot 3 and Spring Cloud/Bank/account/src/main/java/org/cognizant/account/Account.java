package org.cognizant.account;

import java.util.Objects;

public class Account {
    String number;
    String type;
    Double balance;

    public Account() { }

    public Account(String number, String type, Double balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "Account{\n" +
                "number='" + number + '\n' +
                ", type='" + type + '\n' +
                ", balance=" + balance + '\n' +
                '}';
    }
}
