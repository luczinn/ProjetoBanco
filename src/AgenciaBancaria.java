import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();

        operacoes();
    }

    public static void operacoes(){

        int operacao = Integer.parseInt(JOptionPane.showInputDialog("---------------------------------------------------------------------" +
                "\n-------------Bem vindos a nossa Agência---------------" +
                "\n---------------------------------------------------------------------" +
                "\n** Selecione uma operação que deseja realizar **" +
                "\n---------------------------------------------------------------------" +
                "\nOpção 1 - Criar conta" +
                "\nOpção 2 - Depositar" +
                "\nOpção 3 - Sacar" +
                "\nOpção 4 - Transferir" +
                "\nOpção 5 - Listar" +
                "\nOpção 6 - Sair"));


        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Finalizando sistema, até a próxima!");
                System.exit(0);

            default:
                JOptionPane.showMessageDialog(null, "Operação inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        String nome = JOptionPane.showInputDialog("Nome:");

        String email = JOptionPane.showInputDialog("Email:");

        String cpf = JOptionPane.showInputDialog("CPF:");

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!" +
                "\nINFORMAÇÔES:" +
                "\n" + conta.toString());

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (contasBancarias.size() > 0){
            for (int i = 0; i < contasBancarias.size(); i++) {
                if (numeroConta == contasBancarias.get(i).getNumeroConta()){
                    conta = contasBancarias.get(i);
                }
            }
        }

        return conta;
    }

    public static void depositar(){
        int nConta = Integer.parseInt(JOptionPane.showInputDialog("N° da conta: "));
        Conta encontrarConta = encontrarConta(nConta);
        verificarConta(encontrarConta);

        double valor = Integer.parseInt(JOptionPane.showInputDialog("Valor do depósito: "));
        encontrarConta.depositar(valor);

        operacoes();
    }

    public static void sacar(){
        int nConta = Integer.parseInt(JOptionPane.showInputDialog("N° da conta:"));

        Conta encontrarConta = encontrarConta(nConta);
        verificarConta(encontrarConta);

        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do saque: "));
        encontrarConta.sacar(valor);

        operacoes();
    }

    public static void transferir(){
        int nContaTransferencia = Integer.parseInt(JOptionPane.showInputDialog("N° da conta que fará a transferência: "));
        Conta contaTranferencia = encontrarConta(nContaTransferencia);
        verificarConta(contaTranferencia);


        int nContaDeposito = Integer.parseInt(JOptionPane.showInputDialog("N° da conta para depósito: "));
        Conta contaDeposito = encontrarConta(nContaDeposito);
        verificarConta(contaDeposito);

        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));

        contaTranferencia.transferir(contaDeposito, valor);

        operacoes();
    }

    public static void listar(){
        String contas = "";
        if (contasBancarias.size() == 0){
            JOptionPane.showMessageDialog(null, "Lista de contas vazia!");
        }

        else {
            for (int i = 0; i < contasBancarias.size(); i++) {
                contas += contasBancarias.get(i).toString() + "\n";
            }

            JOptionPane.showMessageDialog(null, contas);
        }

        operacoes();
    }

    public static void verificarConta(Conta conta){
        if (conta == null){
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            operacoes();
        }
    }

}
