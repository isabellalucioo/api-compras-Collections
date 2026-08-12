import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensagem mensagem = new Mensagem();
        ArrayList<Produto> listaCompras = new ArrayList<>();

        Menu menu = new Menu(scanner, mensagem, listaCompras);

        //Recebendo os atributos do cartao
        double saldo = menu.inserirSaldo();
        while (saldo <= 0) {
            mensagem.invalido();
            saldo = menu.inserirSaldo();
        }

        CartaoCredito cartao = new CartaoCredito(saldo);
        scanner.nextLine();

        //inicia do menu
        int opcao = 1;
        while (opcao != 0) {
            if (opcao == 1) {
                //Recebendo os atributos de Produto
                String nome = menu.inserirNomeProduto();
                double preco = menu.inserirPreco();
                while (preco < 0) {
                    mensagem.invalido();
                    preco = menu.inserirPreco();
                }
                scanner.nextLine();
                //Criando o novo produto
                Produto produto = new Produto(nome, preco);

                //Realiza compra se o limite estiver de acordo
                if (cartao.realizarCompra(preco)) {
                    listaCompras.add(produto);
                }

            } else if (opcao == 2) {
                //Cancela opcao 2 porque ta vazio
                if (listaCompras.isEmpty()) {
                    mensagem.carrinhoVazio();
                } else {
                    mensagem.Devolucao();
                    menu.visualizarLista();

                    int produtoDevolvido = scanner.nextInt();
                    scanner.nextLine();
                    Produto devolvido = listaCompras.remove(produtoDevolvido);

                    cartao.devolverCompra(devolvido.getPreco());
                }

            } else if (opcao > 2 || opcao < 0) {
                mensagem.invalido();
            }

            // Acao basica do loop, tem que sempre voltar pra ca
            mensagem.menu();
            opcao = scanner.nextInt();
            scanner.nextLine();

        }

        menu.finalizarCompra();
        System.out.print(mensagem.limiteRestante() + cartao.getSaldo());
    }

    }

