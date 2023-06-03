package interfaces_and_abstract_classes.list10Q06;

public class ImpossivelVerificar extends Exception {
    @Override
    public String getMessage() {
        return "[Erro] Sem objetos cadastrados";
    }
}
