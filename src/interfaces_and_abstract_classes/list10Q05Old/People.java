package interfaces_and_abstract_classes.list10Q05Old;

public abstract class People {
    private String name;
    private String cpf;
    private String birthdate;

    public People(String name, String cpf, String birthdate) {
        setName(name);
        setCpf(cpf);
        setBirthdate(birthdate);
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
