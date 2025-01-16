import java.util.Scanner;

public class Conta {
    private String nome;
    private double saldo;
    private final int conta;

    public Conta(String nome, double saldo, int conta) {
        this.nome = nome;
        this.saldo = saldo;
        this.conta = conta;
    }

    public static Conta criarConta(Scanner scan) {
        double quantidade;
        System.out.print("Insira o número da conta: ");
        int numeroConta = scan.nextInt();
        scan.nextLine();

        System.out.print("Haverá um deposito inicial (s/n)? ");
        char resposta = scan.next().charAt(0);
        scan.nextLine();

        if (resposta == 's') {
            System.out.print("Deposito inicial: $");
            quantidade = scan.nextDouble();
            scan.nextLine();
        } else {
            quantidade = 0;
        }

        System.out.print("Qual é o nome do titular: ");
        String nome = scan.nextLine();

        return new Conta(nome, quantidade, numeroConta);
    }

    public static void mostrarMenu() {
        System.out.print("""
                1) Realizar saque
                2) Realizar deposito
                3) Alterar nome
                4) Exibir informações
                5) Encerrar programa
                
                Sua opção:\s""");
    }

    public void deposito(Scanner scan) {
        System.out.print("Quant você deseja depositar? ");
        double quantidade = scan.nextDouble();
        scan.nextLine();
        this.saldo += quantidade;
    }

    public void saque(Scanner scan) {
        System.out.print("Quanto você deseja sacar? ");
        double quantidade = scan.nextDouble();
        this.saldo -= (quantidade + 5);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setNome(Scanner scan) {
        System.out.print("Insira o nome: ");
        this.nome = scan.nextLine();
    }

    @Override
    public String toString() {
        return "Account " + this.conta + " Holder: " + this.nome + ", Balance: $ " + this.saldo;
    }

}
