package Lista10Q05;

public class OperacaoNegativa extends Exception {
    @Override
    public String getMessage() {
        return "[ERRO] Salário negativo";
    }
}
