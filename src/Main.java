import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensagem mensagem = new Mensagem();
        ArrayList<Produto> listaCompras = new ArrayList<>();

        Menu menu = new Menu(scanner, mensagem, listaCompras);

        CartaoCredito cartao = new CartaoCredito(menu.inserirSaldo());
        scanner.nextLine();

        int opcao = 1;
        while (opcao != 0) {
            if (opcao == 1) {
                String nome = menu.inserirNomeProduto();
                double preco = menu.inserirPreco();
                Produto produto = new Produto(nome, preco);

                if (cartao.autorizarCompra(preco)) {
                    menu.adicionarAoCarrinho(produto);
                } else {
                    mensagem.limiteInsufi();
                }

            } else if (opcao == 2) {
                if (menu.devolverCompraAutorizado()){
                    cartao.reembolsaCompra(menu.produtoDevolvido());
                }

            } else {
                mensagem.invalido();
            }

            mensagem.menu();
            opcao = scanner.nextInt();
            scanner.nextLine();
        }

        menu.finalizarCompra();
        System.out.print(mensagem.limiteRestante() + cartao.getSaldo());
    }
    }

