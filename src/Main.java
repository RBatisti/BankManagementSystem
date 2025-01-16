import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Conta> contas = new HashMap<>();
        Conta conta;

        Conta contaAcessada;
        boolean funcionando = true;
        boolean logado = false;
        int opc;
        int numeroConta;

        Scanner scan=new Scanner(System.in);


        while (funcionando) {
            Gerenciador.mostrarMenu();
            opc = scan.nextInt();
            scan.nextLine();

            switch (opc) {
                case 1:
                    System.out.print("Insira o número da conta: ");
                    numeroConta = scan.nextInt();
                    scan.nextLine();

                    if (!Gerenciador.existeConta(numeroConta, contas)) {
                        conta = Conta.criarConta(scan, numeroConta);
                        contas.put(conta.getConta(), conta);
                    } else {
                        System.out.println("Conta já registrada!\n");
                    }

                    break;
                case 2:
                    for (Conta contaTemporaria : contas.values()) {
                        System.out.println(contaTemporaria);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scan.nextInt();
                    scan.nextLine();

                    if (Gerenciador.existeConta(numeroConta, contas)) {

                        logado = true;
                        contaAcessada = contas.get(numeroConta);
                        System.out.println(contaAcessada.getNome() + ", seja bem-vindo!");
                        while (logado) {
                            Gerenciador.mostrarMenuLogado();
                            opc = scan.nextInt();

                            switch (opc) {
                                case 1:
                                    System.out.println(contaAcessada);
                                    break;

                                case 2:
                                    contaAcessada.saque(scan);
                                    break;

                                case 3:
                                    contaAcessada.deposito(scan);
                                    break;

                                case 5:
                                    contaAcessada = null;
                                    logado = false;
                                    break;

                                default:
                                    System.out.println("Insira um númeor de 1 a 5!\n");
                                    break;
                            }

                        }
                    } else {
                        System.out.println("A conta inserida não existe!\n");
                    }
                    break;

                case 4:
                    funcionando = false;
                    break;

                default:
                    System.out.println("Insira um número de 1 a 5\n");
            }
        }
        scan.close();
    }
}