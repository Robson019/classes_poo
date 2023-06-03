package list08Q2;

public class Savings extends Account{
    public Savings(String number, double tax, double balance, String bank) {
        super(number, tax, balance, bank);
    }

    public double savingsUpdate() {
        return ((100 + super.getTax())/100 * super.getBalance());
    }
}
