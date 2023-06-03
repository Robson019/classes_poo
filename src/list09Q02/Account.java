package list09Q02;

public class Account {
    private String number;
    private String clientCpf;
    private double tax;
    private double balance;
    private String bankName;

    public String getNumber() {
        return number;
    }

    public Account(String number, String clientCpf, double tax, double balance, String bankName) {
        setNumber(number);
        setClientCpf(clientCpf);
        setTax(tax);
        setBalance(balance);
        setBankName(bankName);
    }

    public void setNumber(String number) {
        if (number.length() != 4) {
            System.out.println("[ERROR] Number length error");
            this.number = null;
        } else {
            this.number = number;
        }
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        if (clientCpf.length() != 14) {
            System.out.println("[ERROR] Client cpf length error");
            this.clientCpf = null;
        } else {
            this.clientCpf = clientCpf;
        }
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
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void update() {
        this.balance = 0+this.balance;
    }

    public void withdraw(double value) {
        if (value > this.balance || value < 0) {
            System.out.println("[ERROR] Invalid value");
        } else {
            this.balance -= value;
            update();
            System.out.println("Success");
        }
    }

    public void deposit(double value) {
        if (value < 0) {
            System.out.println("[ERROR] Negative value");
        } else {
            this.balance += value;
            update();
            System.out.println("Success");
        }
    }
}
