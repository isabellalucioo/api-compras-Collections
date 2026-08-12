import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    Scanner scanner;
    Mensagem mensagem;
    ArrayList<Produto> listaCompras;

    public Menu(Scanner scanner, Mensagem mensagem, ArrayList<Produto> listaCompras) {
        this.scanner = scanner;
        this.mensagem = mensagem;
        this.listaCompras = listaCompras;
    }

    public double inserirSaldo(){
        mensagem.insertLimite();
        return scanner.nextDouble();
    }

    public String inserirNomeProduto() {
        mensagem.insertProduto();
        return scanner.nextLine();
    }

    public double inserirPreco(){
        mensagem.insertValor();
        return scanner.nextDouble();
    }

    public boolean devolverCompra(){
        return true;
    }

    public void finalizarCompra(){
        Collections.sort(listaCompras, Collections.reverseOrder());
        for (Produto item : listaCompras){
            System.out.println(item);
        }
        mensagem.compraFinalizada();
    }

    public void visualizarLista(){
        for (int i = 0; i < listaCompras.size(); i++) {
            System.out.println(i + " - " + listaCompras.get(i));
        }
    }



}
