public class CartaoCredito {
    private double saldo;


    public CartaoCredito(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean autorizarCompra(double preco){
        if (saldo >= preco){
            saldo -= preco;
            return true;
        }
            return false;
    }

    public void reembolsaCompra(double preco){
        saldo = saldo + preco;
    }

}
