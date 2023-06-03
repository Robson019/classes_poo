package Lista10Q05;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void  q5Menu(Scanner scan, List<Funcionario> f, List<Gerente> g) {
        int opc;
        boolean funCad = false, gerCad = false;

        do {
            opc = lerOpc(scan, funCad, gerCad);

            if (opc == 1) {
                Funcionario novoFuncionario = novoF(scan);
                if (novoFuncionario != null) {
                    f.add(novoFuncionario);
                    funCad = true;
                }
            } else if (opc == 2) {
                Gerente novoGerente = novoG(scan);
                if (novoGerente != null) {
                    g.add(novoGerente);
                    gerCad = true;
                }
            } else if (opc == 3 && funCad) {
                obterSalarioF(scan, f);
            } else if (opc == 4 && gerCad) {
                obterSalarioG(scan, g);
            }
        } while (opc != 0);
        System.out.println("Adeus");
    }

    public static Gerente buscarCpfGer(Scanner scan, List<Gerente> g) {
        String cpfPesquisado = "";
        boolean verificado = false;
        try {
            System.out.print("Digite o CPF: ");
            cpfPesquisado = scan.next();
            if (cpfPesquisado.length() != 11) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("[Erro] ao digitar cpf");
            scan.nextLine();
            verificado = true;
        }

        if (!verificado) {
            for (Gerente ger :g) {
                if (ger.getCpf().equals(cpfPesquisado)) {
                    return ger;
                }
            }
        }

        System.out.println("[Erro] Funcionario não encontrado");
        return null;
    }

    public static void obterSalarioG(Scanner scan, List<Gerente> g) {
        Gerente gerPesquisado = buscarCpfGer(scan, g);

        if (gerPesquisado != null) {
            System.out.println("Salário de "+gerPesquisado.getNome()+", R$"+gerPesquisado.getSalario());
        }
    }

    public static Funcionario buscarCpfFunc(Scanner scan, List<Funcionario> f) {
        String cpfPesquisado = "";
        boolean verificado = false;
        try {
            System.out.print("Digite o CPF: ");
            cpfPesquisado = scan.next();
            if (cpfPesquisado.length() != 11) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("[Erro] ao digitar cpf");
            scan.nextLine();
            verificado = true;
        }

        if (!verificado) {
            for (Funcionario func :f) {
                if (func.getCpf().equals(cpfPesquisado)) {
                    return func;
                }
            }
        }

        System.out.println("[Erro] Funcionario não encontrado");
        return null;
    }

    public static void obterSalarioF(Scanner scan, List<Funcionario> f) {
        Funcionario funcPesquisado = buscarCpfFunc(scan, f);

        if (funcPesquisado != null) {
            System.out.println("Salário de "+funcPesquisado.getNome()+", R$"+funcPesquisado.getSalario());
        }
    }

    public static Funcionario novoF(Scanner scan) {
        boolean verificado = false;
        String nome = "", cpf = "", nasc = "";
        double salario = 0;
        try {
            System.out.print("Digite o nome: ");
            scan.nextLine();
            nome = scan.nextLine();
            System.out.print("Digite o cpf (apenas numeros): ");
            cpf = scan.next();
            if (cpf.length() != 11) {
                throw new Exception();
            }
            System.out.print("Digite data de nascimento (dd/mm/aaaa): ");
            nasc = scan.next();
            if (nasc.length() != 10) {
                throw new Exception();
            }
            System.out.print("Salário: R$");
            salario = scan.nextDouble();
            if (salario < 0) {
                throw new OperacaoNegativa();
            }
        } catch (OperacaoNegativa e) {
            System.out.println(e.getMessage());
            scan.nextLine();
            verificado = true;
        }catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            verificado = true;
        }

        if (!verificado) {
            Funcionario f = new Funcionario(nome, cpf, nasc, salario);
            System.out.println("Funcionario cadastrado!");

            return f;
        }

        return null;
    }

    public static Gerente novoG(Scanner scan) {
        boolean verificado = false;
        String nome = "", cpf = "", nasc = "", dep = "";
        double salario = 0;
        try {
            System.out.print("Digite o nome: ");
            scan.nextLine();
            nome = scan.nextLine();
            System.out.print("Digite o cpf (apenas numeros): ");
            cpf = scan.next();
            if (cpf.length() != 11) {
                throw new Exception();
            }
            System.out.print("Digite data de nascimento (dd/mm/aaaa): ");
            nasc = scan.next();
            if (nasc.length() != 10) {
                throw new Exception();
            }
            System.out.print("Salário: R$");
            salario = scan.nextDouble();
            if (salario < 0) {
                throw new OperacaoNegativa();
            }
            System.out.print("Departamento: ");
            scan.nextLine();
            dep = scan.nextLine();
        } catch (OperacaoNegativa e) {
            System.out.println(e.getMessage());
            scan.nextLine();
            verificado = true;
        } catch (Exception e) {
            System.out.println("[Erro] Campo inválido");
            scan.nextLine();
            verificado = true;
        }

        if (!verificado) {
            Gerente g = new Gerente(nome, cpf, nasc, salario, dep);
            System.out.println("gerente cadastrado!");

            return g;
        }

        return null;
    }

    public static int lerOpc(Scanner scan, boolean funCad, boolean gerCad) {
        System.out.print("Menu\n1. Adicionar funcionário\n2. Adicionar Gerente\n3. Obter salário de Funcionário\n4. Obter salário de Gerente\n0. SAIR\nOpção: ");
        int opt = -1;

        try {
            opt = scan.nextInt();
            if (opt < 0 || opt > 4) {
                throw new InputMismatchException();
            }
            if ((opt == 3 && !funCad) || (opt == 4 && !gerCad)) {
                throw new ImpossivelVerificar();
            }
        } catch (InputMismatchException e) {
            System.out.println("[Erro] Você digitou algo inválido");
            scan.nextLine();
        } catch (ImpossivelVerificar e) {
            System.out.println("[Erro] Lista vazia.");
        }

        return opt;
    }
}
