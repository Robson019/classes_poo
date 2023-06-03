package list09Q02;

public class Savings extends Account {
    public Savings(String number, String clientCpf, double tax, double balance, String bankName) {
        super(number, clientCpf, tax, balance, bankName);
    }

    public void update() {
        super.setBalance(super.getBalance()+super.getTax());
    }
}
