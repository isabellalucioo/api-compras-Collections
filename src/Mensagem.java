public class Mensagem {

    void insertLimite(){
        System.out.println("\uD83D\uDCB3-----Insira o limte do cartão:-----\uD83D\uDCB3");
    }

    String limiteRestante(){
        return "Limite do cartão restante: R$ ";
    }

    void menu(){
        System.out.println("Digite 0 pra finalizar compra, 1 para adicionar itens na compra e 2 para devolver");
    }

    void insertProduto(){
        System.out.println("Insira o nome do produto:");
    }

    void insertValor(){
        System.out.println("Insira o valor do produto:");
    }

    void limiteInsufi(){
        System.out.println("Limite Insuficiente");
    }

    void invalido(){
        System.out.println("Digite um valor válido.");
    }

    void compraRealizada(){
        System.out.println("Adicionado ao Carrinho!");
    }

    void compraFinalizada(){
        System.out.println("Compra finalizada.");
        System.out.println("-----Recibo-----");
    }

    void Devolucao(){
        System.out.println("digite o numero do produto pra devolvê-lo:");
    }

    void produtoDevolvido(){
        System.out.println("Produto devolvido.");
    }

    void carrinhoVazio(){
        System.out.println("Não há produtos a serem devolvidos.");
    }






}
