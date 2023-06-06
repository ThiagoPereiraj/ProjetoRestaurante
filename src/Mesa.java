public class Mesa extends FazerPedido {
    int numeroMesa;

    public Mesa(int id, int qtdPedido, int numeroMesa) {
        super(id, qtdPedido);
        this.setNumeroMesa(numeroMesa);
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
