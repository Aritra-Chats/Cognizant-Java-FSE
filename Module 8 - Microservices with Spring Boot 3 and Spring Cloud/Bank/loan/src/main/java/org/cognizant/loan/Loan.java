package org.cognizant.loan;

import java.util.Objects;

public class Loan {
    String number;
    String type;
    Double loan;
    Double emi;
    int tenure;

    public Loan() { }

    public Loan(String number, String type, Double loan, Double emi, int tenure) {
        this.number = number;
        this.type = type;
        this.loan = loan;
        this.emi = emi;
        this.tenure = tenure;
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

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getEmi() {
        return emi;
    }

    public void setEmi(Double emi) {
        this.emi = emi;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(number, loan.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "\nnumber='" + number + '\'' +
                "\n, type='" + type + '\'' +
                "\n, loan=" + loan +
                "\n, emi=" + emi +
                "\n, tenure=" + tenure +
                "\n}";
    }
}
