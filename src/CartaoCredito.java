public class CartaoCredito {
    double saldo;
    Mensagem mensagem;

    public CartaoCredito(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean realizarCompra(double preco){
        if (saldo >= preco){
            saldo = getSaldo() - preco;            ;
            return true;
        }
            return false;
    }

    public void devolverCompra(double preco){
        saldo = saldo + preco;
    }

}
