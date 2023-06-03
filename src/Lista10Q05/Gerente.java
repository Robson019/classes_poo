package Lista10Q05;

public class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, String cpf, String dataNasc, double salario, String departamento) {
        super(nome, cpf, dataNasc, salario);
        setDepartamento(departamento);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public double getSalario() {
        return super.getSalario() + 1500;
    }
}
