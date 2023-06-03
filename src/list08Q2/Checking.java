package list08Q2;

public class Checking extends Account {
    public Checking(String number, double tax, double balance, String bank) {
        super(number, tax, balance, bank);
    }

    public double checkingUpdate() {
        return ((100 - super.getTax())/100 * super.getBalance());
    }
}
