import utilitario.Utils;

import javax.swing.*;

public class Conta {

    private static int contadorDeContas = 1;

    private int numeroConta;
    private double saldo;
    private Pessoa pessoa;

    public Conta (Pessoa pessoa){
        numeroConta = contadorDeContas;
        this.saldo = 0.0;
        this.pessoa = pessoa;

        contadorDeContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String toString(){
        return "\nNumero da Conta: " + getNumeroConta()
                + pessoa.toString()
                + "\nSaldo: " + saldoFormatado();
    }

    public void depositar (double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            sucessMsg();
        }
        else {
            failMsg();
        }


    }

    public void sacar (double valor) {
        double taxa = 0.10 * saldo;
        if (valor <= saldo && valor > 0) {
            saldo -= valor + taxa;
            System.out.println("Taxa de 10% descontada");
            sucessMsg();
        }
        else {
            failMsg();
        }
    }

    public void transferir(Conta contaParaDeposito, double valor){
        if (valor > 0 && valor <= saldo){
            saldo -= valor;

            contaParaDeposito.setSaldo(getSaldo() + valor);
            sucessMsg();
        }
        else {
            failMsg();
        }
    }




    public String saldoFormatado(){
        return Utils.formatarEmReais(saldo);
    }

    private void sucessMsg(){
        JOptionPane.showMessageDialog(null, "Seu pedido foi realizado com sucesso!");
    }

    private void failMsg(){
        JOptionPane.showMessageDialog(null, "Seu pedido não foi realizado!");
    }


}
