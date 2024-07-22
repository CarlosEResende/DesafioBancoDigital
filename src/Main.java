public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
       
        

        Conta cc = new ContaCorrente(cliente);
        Conta cp = new ContaPoupanca(cliente);

        //Conta Corrente
        
        
        cc.depositar(500);
        cc.sacar(40); 
        cc.depositar(20); 
        cc.transferir(cp, 10); 

        //cc.transferir(cp, 50);  // 50 será retirado de cc e adicionado a cp
        
        //Conta Poupança

        //cp.depositar(100);
        //cp.sacar(25);
        //cp.transferir(cc, 10);

    
        //cc.imprimirExtrato();
        cc.imprimirTotais();
        //cp.imprimirExtrato();

        
        

      
        
    }

}
