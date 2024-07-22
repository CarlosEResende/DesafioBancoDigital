public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("============================================================");
        System.out.println("Extrato Conta Poupanca");
        imprimirInformacoesComuns();
        System.out.println("============================================================");

        
    }


    
}
