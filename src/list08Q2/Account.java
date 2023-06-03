package list08Q2;

public class Account {
    private String number;
    private double tax;
    private double balance;
    private String bank;

    public Account(String number, double tax, double balance, String bank) {
        setNumber(number);
        setTax(tax);
        setBalance(balance);
        setBank(bank);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void withdraw(double value) {
        if (value >= 0) {
            this.balance -= value;
        }
    }

    public void deposit(double value) {
        if (value >= 0) {
            this.balance += value;
        }
    }
}
