public class Menu {

    void mensagemInsertLimite(){
        System.out.println("\uD83D\uDCB3-----Insira o limte do cartão:-----\uD83D\uDCB3");
    }

    String mensagemLimiteRestante(){
        return "Limite do cartão restante: R$ ";
    }

    void mensagemMenu(){
        System.out.println("Digite 0 pra finalizar compra, 1 para adicionar itens na compra e 2 para devolver");
    }

    void mensagemInsertProduto(){
        System.out.println("Insira o nome do produto:");
    }

    void mensagemInsertValor(){
        System.out.println("Insira o valor do produto:");
    }

    void mensagemLimiteInsufi(){
        System.out.println("Limite Insuficiente");
    }

    void mensagemInvalido(){
        System.out.println("Digite um valor válido.");
    }

    void compraRealizada(){
        System.out.println("Adicionado ao Carrinho!");
    }

    void compraFinalizada(){
        System.out.println("Compra finalizada.");
        System.out.println("-----Recibo-----");
    }

    void menuDevolucao(){
        System.out.println("digite o numero do produto pra removê-lo:");
    }

    String produtoDevolvido(){
        return " devolvido.";
    }

    void carrinhoVazio(){
        System.out.println("Não há produtos a serem devolvidos.");
    }






}
