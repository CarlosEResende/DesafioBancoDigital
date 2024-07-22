
public abstract class Conta implements InterfaceConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;

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

        else if (valor > saldo) {
            System.err.println("Saldo Insuficiente!");
            return;
        }

        this.saldo -= valor;
        System.out.println("Saque no Valor de: " + valor + " Realizado com Sucesso!");

    }

    @Override
    public void depositar(double valor) {

        if (valor <= 0) {
            System.out.println("O valor de depósito deve ser positivo e maior que zero.");
            return;
        }

        this.saldo += valor;

        System.out.println("Deposito no Valor de: " + valor + " Realizado com Sucesso!");


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
    
        this.sacar(valor); 
        contaDestino.depositar(valor); 
        System.out.println("Transferência Realizada com Sucesso!");
        

    }

    protected void imprimirInformacoesComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.err.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
