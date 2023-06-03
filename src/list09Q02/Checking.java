package list09Q02;

public class Checking extends Account {
    public Checking(String number, String clientCpf, double tax, double balance, String bankName) {
        super(number, clientCpf, tax, balance, bankName);
    }

    public void update(double tax) {
        super.setBalance(super.getBalance()-tax);
    }

    public void withdraw(double value) {
        if (value > super.getBalance() || value < 0) {
            System.out.println("[ERROR] Invalid value");
        } else {
            super.setBalance(super.getBalance()-value);
            update(0.3);
            System.out.println("Success");
        }
    }
}
