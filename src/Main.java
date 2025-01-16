import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean funcionando = true;
        int opc;

        Scanner scan=new Scanner(System.in);

        Conta conta = Conta.criarConta(scan);

        System.out.println(conta);

        while (funcionando) {
            Conta.mostrarMenu();
            opc = scan.nextInt();
            scan.nextLine();

            switch (opc) {
                case 1:
                    conta.saque(scan);
                    break;
                case 2:
                    conta.deposito(scan);
                    break;
                case 3:
                    conta.setNome(scan);
                    break;
                case 4:
                    System.out.println(conta);
                    break;
                case 5:
                    funcionando = false;
                    break;
                default:
                    System.out.println("Insira um número de 1 a 5");
            }
        }

        scan.close();
    }

}