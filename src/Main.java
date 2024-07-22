public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
        

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        //Conta Corrente
        cc.depositar(1500);
        cc.transferir(cp, 340);

        //Conta Poupança

        cp.depositar(450);
        cp.depositar(120);
        cc.imprimirExtrato();
        cp.imprimirExtrato();

      
        
    }

}
