package list08Q1;

public class People {
    private String name;
    private String cpf;
    private String birthDate;

    public People(String name, String cpf, String birthDate) {
        setName(name);
        setCpf(cpf);
        setBirthDate(birthDate);
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
        if (cpf.length() != 14) {
            System.out.println("[ERROR] Invalid CPF");
        } else {
            this.cpf = cpf;
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.length() != 10) {
            System.out.println("[ERROR] Invalid birthdate");
        } else {
            this.birthDate = birthDate;
        }
    }
}
