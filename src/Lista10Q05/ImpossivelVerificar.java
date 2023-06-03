package Lista10Q05;

public class ImpossivelVerificar extends Exception {
    @Override
    public String getMessage() {
        return "[Erro] Sem objetos cadastrados";
    }
}
