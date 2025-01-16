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

    public static Conta criarConta(Scanner scan, int numeroConta) {
        double quantidade;

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
        System.out.println();

        return new Conta(nome, quantidade, numeroConta);
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
        scan.nextLine();
        if (this.saldo < quantidade) {
            System.out.println("Saldo insuficiente!\n");
        } else {
            this.saldo -= quantidade;
        }
    }

    public int getConta() {
        return this.conta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(Scanner scan) {
        System.out.print("Insira o nome: ");
        this.nome = scan.nextLine();
    }

    @Override
    public String toString() {
        return String.format("Conta: " + this.conta + ", Proprietário: " + this.nome + ", Saldo: $%.2f", this.saldo);
    }
}
