import java.util.ArrayList;

public class Comanda extends Pedido {   

    public Comanda(int id, int qtdPedido) {
        super(id, qtdPedido);
    }


    public static double imprimirComanda(ArrayList<Mesa> listaPedido,int numeroMesa){
        double totalMesa=0;
        System.out.println("Consumo:\t\t\t\t\tQuantidade:\t\t\t\tTotal:\n");
        for (int i=0;i<=listaPedido.size()-1;i++){
            if(listaPedido.get(i).getNumeroMesa()==numeroMesa){
                double totalId=calculaTotal(listaPedido.get(i).getId(),listaPedido.get(i).getQtdPedido());
                totalMesa+=totalId;
                String nomePedido=tranformarId(listaPedido.get(i).getId());
                System.out.println(nomePedido+"\t\t\t\t"+listaPedido.get(i).getQtdPedido()+"\t\t\t\t\tR$ "+totalId);

            }
        }
        System.out.println("\nTotal a pagar.......................................R$ "+totalMesa+"\n\n");
        return totalMesa;
    }
    public static double calculaTotal(int id, int qtd){
        double preco=0;
        switch (id) {
            case 1 -> preco = 15;
            case 2 -> preco = 12;
            case 3 -> preco = 14;
            case 4 -> preco = 14.5;
            case 5 -> preco = 8;
            case 6 -> preco = 6;
            case 7 -> preco = 7;
            case 8 -> preco = 6.5;
            case 9 -> preco = 3;
            case 10 -> preco = 5;
        }
        return preco * qtd;

    }
    public static String tranformarId(int id){
        String nomeId=" ";
        switch (id){
            case 1 -> nomeId = "CHEESEBURGUER    ";
            case 2 -> nomeId = "VEGGIE BURGER    ";
            case 3 -> nomeId = "FRANGO GRELHADO  ";
            case 4 -> nomeId = "SANDUICHE DE ATUM";
            case 5 -> nomeId = "REFRIGERANTE     ";
            case 6 -> nomeId = "SUCO DE LARANJA  ";
            case 7 -> nomeId = "SUCO DE MARACUJÁ ";
            case 8 -> nomeId = "SUCO DE ABACAXI  ";
            case 9 -> nomeId = "ÁGUA MINERAL     ";
            case 10 -> nomeId = "ÁGUA DE COCO    ";

        }
        return nomeId;
    }
    public static void realizarPagamento(ArrayList<Mesa> listaPedido,int numeroMesa){

        

        for (int i=0;i<=listaPedido.size()-1;i++){
            if(listaPedido.get(i).getNumeroMesa()==numeroMesa){
                listaPedido.remove(i);
                    i--;
            }

        }
        System.out.println("\nPagamento realizado com sucesso!\n\n");
    }
}
