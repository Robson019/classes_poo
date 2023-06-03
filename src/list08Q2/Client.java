package list08Q2;

public class Client {
    private String name;
    private String cpf;
    private Checking checkingAccount;
    private Savings savingsAccount;

    public Client(String name, String cpf, Checking checkingAccount, Savings savingsAccount) {
        setName(name);
        setCpf(cpf);
        setCheckingAccount(checkingAccount);
        setSavingsAccount(savingsAccount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Checking getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Checking checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Savings getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(Savings savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
