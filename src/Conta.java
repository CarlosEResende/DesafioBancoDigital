import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements InterfaceConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected int quantidadeSaques = 0;
    protected int quantidadeDepositos = 0;
    protected int quantidadeTransferencias = 0;

    protected Cliente cliente;

    private List<Double> saques = new ArrayList<>();
    private List<Double> depositos = new ArrayList<>();
    private List<Double> transferencias = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor de saque deve ser positivo e maior que zero.");
            return;
        }

        if (valor > saldo) {
            System.err.println("Saldo Insuficiente!");
            return;
        }

        // Realize o saque
        this.saldo -= valor;
        saques.add(valor);
        quantidadeSaques++;
        System.out.println("Saque no Valor de: " + valor + " Realizado com Sucesso!");
    }

    @Override
    public void depositar(double valor) {

        if (valor <= 0) {
            System.out.println("O valor de depósito deve ser positivo e maior que zero.");
            return;
        }

        // Realiza o depósito
        this.saldo += valor;
        depositos.add(valor);
        quantidadeDepositos++;
        System.out.println("Depósito no Valor de: " + valor + " Realizado com Sucesso!");
    }

    @Override
    public void transferir(InterfaceConta contaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("O valor da transferência deve ser positivo e maior que zero.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo Insuficiente para Transferência!");
            return;
        }

        // Realiza a transferência
        this.saldo -= valor;
        contaDestino.depositar(valor);
        transferencias.add(valor);
        quantidadeTransferencias++;
        System.out.println("Transferência Realizada com Sucesso!");
    }

    private double calcularTotalSaques() {
        return saques.stream().mapToDouble(Double::doubleValue).sum();
    }

    private double calcularTotalDepositos() {
        return depositos.stream().mapToDouble(Double::doubleValue).sum();
    }

    private double calcularTotalTransferencias() {
        return transferencias.stream().mapToDouble(Double::doubleValue).sum();
    }

    protected void imprimirInformacoesComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo Atual: %.2f", this.saldo));
    }

    public void imprimirTotais() {
        System.out.println("Saques Realizados: " + quantidadeSaques + " || Valor Total: " + calcularTotalSaques());
        System.out.println("Depósitos Realizados: " + quantidadeDepositos + " || Valor Total: " + calcularTotalDepositos());
        System.out.println("Transferências Realizadas: " + quantidadeTransferencias + " || Valor Total: " + calcularTotalTransferencias());
    }
}
