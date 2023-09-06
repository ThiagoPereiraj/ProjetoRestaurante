import java.util.ArrayList;

public abstract class Pedido {
    int id;
    int qtdPedido;
    public Pedido(int id, int qtdPedido) {
        this.setId(id);
        this.setQtdPedido(qtdPedido);
    }
    public static void entregaPedido(ArrayList<Integer> atendimento ){
        for (int m:atendimento) {
            System.out.println("\nPedido mesa "+m+": Pronto!!");
            System.out.println("Pedido mesa "+m+": Entregue!!\n\n");
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdPedido() {
        return qtdPedido;
    }

    public void setQtdPedido(int qtdPedido) {
        this.qtdPedido = qtdPedido;
    }

}
