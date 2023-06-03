package Lista10Q05;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String dataNasc;

    public Pessoa(String nome, String cpf, String dataNasc) {
        setNome(nome);
        setCpf(cpf);
        setDataNasc(dataNasc);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
