import java.util.HashMap;

public class Gerenciador {

    protected static boolean existeConta(int numeroConta, HashMap<Integer, Conta> analise) {
        return analise.containsKey(numeroConta);
    }

    public static void mostrarMenu() {
        System.out.print("""
                1) Criar conta
                2) Exibir informações das contas
                3) Entrar em uma conta
                4) Encerrar programa
                
                Sua opção:\s""");
    }

    public static void mostrarMenuLogado() {
        System.out.print("""
                1) Exibir informações da conta
                2) Realizar um saque
                3) Realizar um deposito
                4) Realizar uma transferência
                5) Sair da conta
                
                Sua opção:\s""");
    }
}
