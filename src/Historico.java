import java.util.ArrayList;

public class Historico {
    int numMesa;
    double totalMesa;

    public Historico(int numMesa, double totalMesa) {
        this.numMesa = numMesa;
        this.totalMesa = totalMesa;
    }
    ArrayList<Historico> historico=new ArrayList<>();
    public void historico(int numMesa,double totalMesa){
        int cond=0;
        Historico mesa=new Historico(numMesa,totalMesa);
        for (int i=0;i<=historico.size()-1;i++){
            if(historico.get(i).getNumMesa()==numMesa){
               totalMesa+=historico.get(i).getTotalMesa();
               Historico mesaExistente=new Historico(numMesa,totalMesa);
                historico.set(i,mesaExistente);
                cond=2;
                break;
            }
        }
        if (cond!=2)historico.add(mesa);
    }
    public void inprimirHistorico(){
        System.out.println("\nFaturamento do dia:");
        double totalDia=0;
        for (int i=0;i<=historico.size()-1;i++){
            System.out.println("Mesa "+historico.get(i).getNumMesa()+"\nTotal Faturado: R$ "+historico.get(i).getTotalMesa());
            totalDia+=historico.get(i).getTotalMesa();
        }
        System.out.println("\nFaturamento total do dia: R$ "+totalDia);
    }

    public int getNumMesa() {
        return numMesa;
    }



    public double getTotalMesa() {
        return totalMesa;
    }


}
