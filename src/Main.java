import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        List<Produto> listaCompras = new ArrayList<>();

        //inicializacao do cartao
        menu.mensagemInsertLimite();
        double saldo = (scanner.nextDouble());
        while (saldo <= 0) {
            menu.mensagemInvalido();
            menu.mensagemInsertLimite();
            saldo = (scanner.nextDouble());
        }

        CartaoCredito cartao = new CartaoCredito(saldo);
        scanner.nextLine();

        //Loop do menu
        int opcao = 1;
        while (opcao != 0){
            if (opcao == 1){
                menu.mensagemInsertProduto();
                String nome = scanner.nextLine();


                menu.mensagemInsertValor();
                double preco = scanner.nextDouble();

                while (preco < 0) {
                    menu.mensagemInvalido();
                    menu.mensagemInsertValor();
                    preco = scanner.nextDouble();
                }

                scanner.nextLine();

                if (cartao.getSaldo() >= preco){
                    cartao.setSaldo(cartao.getSaldo() - preco);
                    Produto produto = new Produto(nome, preco);
                    listaCompras.add(produto);
                    menu.compraRealizada();


                } else {
                    menu.mensagemLimiteInsufi();
                }

            } else if (opcao == 2) {
                if (listaCompras.isEmpty()){
                    menu.carrinhoVazio();
                } else {
                    menu.menuDevolucao();
                    for (int i = 0; i < listaCompras.size(); i++){
                        System.out.println(i + " - " + listaCompras.get(i));
                    }

                    int produtoDevolvido = scanner.nextInt();
                    scanner.nextLine();

                    if (produtoDevolvido >= 0 && produtoDevolvido < listaCompras.size()) {
                        Produto devolvido = listaCompras.remove(produtoDevolvido);
                        cartao.setSaldo(cartao.getSaldo() + devolvido.getPreco());
                        System.out.println(devolvido + menu.produtoDevolvido());
                    }
                }

            }else if (opcao > 2 || opcao < 0) {
                menu.mensagemInvalido();

            }

            menu.mensagemMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

        }

        Collections.sort(listaCompras, Collections.reverseOrder());
        for (Produto item : listaCompras){
            System.out.println(item);
        }
        menu.compraFinalizada();
        System.out.print(menu.mensagemLimiteRestante() + cartao.getSaldo());
        }
    }

