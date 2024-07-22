public interface InterfaceConta {

    public void sacar(double valor);

    public void depositar(double valor);

    public void transferir(InterfaceConta contaDestino, double valor);

    void imprimirExtrato();

    void imprimirTotais();
    
}
