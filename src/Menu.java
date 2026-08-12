import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Mensagem mensagem;
    private ArrayList<Produto> listaCompras;

    public Menu(Scanner scanner, Mensagem mensagem, ArrayList<Produto> listaCompras) {
        this.scanner = scanner;
        this.mensagem = mensagem;
        this.listaCompras = listaCompras;
    }

    public double inserirSaldo(){
        mensagem.insertLimite();
        double saldo = scanner.nextDouble();
        while (saldo <= 0) {
            mensagem.invalido();
            saldo = scanner.nextDouble();
        }
        return saldo;
    }

    public String inserirNomeProduto() {
        mensagem.insertProduto();
        return scanner.nextLine();
    }

    public double inserirPreco(){
        mensagem.insertValor();
        double preco = scanner.nextDouble();
        while (preco < 0) {
            mensagem.invalido();
            mensagem.insertValor();
            preco =scanner.nextDouble();
        }
        scanner.nextLine();
        return preco;
    }

    public void adicionarAoCarrinho(Produto produto){
        listaCompras.add(produto);
        mensagem.compraRealizada();
    }

    public void finalizarCompra(){
        Collections.sort(listaCompras);
        mensagem.compraFinalizada();
        for (Produto item : listaCompras){
            System.out.println(item);
        }
    }

    public void visualizarLista(){
        for (int i = 0; i < listaCompras.size(); i++) {
            System.out.println(i + " - " + listaCompras.get(i));
        }
    }

    public boolean devolverCompraAutorizado() {
        if (listaCompras.isEmpty()) {
            mensagem.carrinhoVazio();
            return false;
        }
        mensagem.Devolucao();
        visualizarLista();
        return true;
    }

    public double produtoDevolvido(){
        int produtoDevolvido = scanner.nextInt();
        scanner.nextLine();
        Produto devolvido = listaCompras.remove(produtoDevolvido);
        mensagem.produtoDevolvido();
        return devolvido.getPreco();
    }

}
