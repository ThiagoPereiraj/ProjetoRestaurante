import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int condPedido,opcao;
        ArrayList<Mesa> listaPedido = new ArrayList<>();
        ArrayList<Integer> atendimento = new ArrayList<>();
        ArrayList<Integer> pagamento = new ArrayList<>();
        int[]mesas= new int[15];
        ArrayList<Integer>mesaOcupada=new ArrayList<>();
        for(int i=0;i<mesas.length;i++){
            mesas[i]=i+1;
        }

        do{
            System.out.println("O que deseja fazer:\n1.Atender mesas\n2.Entregar pedidos\n3.Imprimir comanda\n4.Realizar pagamentos\n5.Finalizar programa");
            opcao=sc.nextInt();
            int numeroMesa;
            switch (opcao){
                case 0:
                    break;
                case 1:
                    boolean v;
                    for (int i=0;i<mesas.length;i++){
                        v=true;
                        for (int aux:pagamento){
                            if(aux==mesas[i]){
                                System.out.println("Mesa "+(i+1)+" ocupada");

                                v=false;
                            }
                        }
                        if(v){
                            System.out.println("Mesa "+(i+1)+" livre");
                        }

                    }
                    boolean condMesa;
                    do {
                        condMesa=false;
                        System.out.println("Digite o numero da mesa que deseja atender:");
                        numeroMesa=sc.nextInt();
                        if(numeroMesa>mesas.length){
                            System.out.println("A mesa "+numeroMesa+" não existe! ");
                            condMesa=true;
                        }
                        for(int aux:mesaOcupada){
                            if(aux==numeroMesa){
                                System.out.println("A mesa "+numeroMesa+" está ocupada deseja adicionar mais itens a comanda?\n1. Sim\n2. Não");
                                int op = sc.nextInt();
                                if(op==1){
                                    break;
                                }
                                condMesa=true;
                                break;
                            }
                        }

                    }while (condMesa);
                    int cond=0;
                    for (int aux:pagamento)
                        if (aux == numeroMesa) {
                            cond = 1;
                            break;
                        }
                    if(cond!=1){
                        pagamento.add(numeroMesa);
                        mesaOcupada.add(numeroMesa);
                    }
                    do{
                        condPedido=1;
                        Menu.imprimirMenu();
                        int id;
                        do{
                            System.out.print("Digite o numero do pedido desejado: ");
                            id=sc.nextInt();
                            if(id>10||id<1)System.out.println("Pedido inválido!!");
                        }while(id>10||id<1);

                        System.out.print("Digite a quantidade desejada: ");
                        int qtd= sc.nextInt();
                        Mesa pedido=new Mesa(id,qtd,numeroMesa);

                        for (int i=0;i<=listaPedido.size()-1;i++){
                            if(listaPedido.get(i).getId()==id&&listaPedido.get(i).getNumeroMesa()==numeroMesa){
                                qtd+=listaPedido.get(i).getQtdPedido();
                                Mesa pedidoExistente=new Mesa(id,qtd,numeroMesa);
                                listaPedido.set(i,pedidoExistente);
                                condPedido=2;
                                break;
                            }
                        }
                        if(condPedido!=2){
                            listaPedido.add(pedido);


                        }
                        do{
                            System.out.println("Deseja algo mais?\n1.Sim\n2.Não");
                            condPedido=sc.nextInt();
                            if(condPedido>2||condPedido<1) System.out.println("Opção inválida");
                        }while (condPedido>2||condPedido<1);

                        if(condPedido==2){
                            System.out.println("\nPedido enviado para a cozinha. Aguardando preparo...\n");
                            atendimento.add(numeroMesa);
                        }
                    }while(condPedido==1);
                    break;
                case 2:
                    if (atendimento.size()>0) {
                        Pedido.entregaPedido(atendimento);
                        atendimento.clear();
                    }else System.out.println("Não existem entregas pendentes\n\n");
                    break;
                case 3:
                    System.out.println("Digite o numero da mesa que deseja consultar a comanda: ");
                    numeroMesa=sc.nextInt();
                    int verif=0;
                    for (int aux:pagamento){
                        if(aux==numeroMesa){
                            Comanda.imprimirComanda(listaPedido,numeroMesa);
                            verif=1;
                            break;
                        }
                    }
                    if (verif==0){
                        System.out.println("A mesa "+numeroMesa+" não tem pagamentos pendentes\n\n");
                    }
                    break;
                case 4:
                    boolean teste = false;
                    if(pagamento.size()<1){
                        System.out.println("Não existem pagamentos pendentes! ");
                        break;
                    }
                    System.out.print("A(s) mesa(s) ");
                    for(int aux:pagamento){
                        System.out.print(" ["+aux+"] ");
                    }
                    System.out.println("\nTem pagamentos pendentes!");
                    System.out.println("Digite o numero da mesa que deseja realizar o pagamento: ");
                    numeroMesa=sc.nextInt();
                    for(int aux:atendimento){
                        if(aux==numeroMesa){
                            System.out.println("A mesa: "+numeroMesa+" ainda possui entregas pendentes");
                            teste = true;
                            break;
                        }
                    }
                    if(teste){
                        break;
                    }

                    int verif2=0,index=0;
                    for (int aux:pagamento){
                        if(aux==numeroMesa){
                            double totalMesa=Comanda.imprimirComanda(listaPedido,numeroMesa);
                            Historico.historico(numeroMesa,totalMesa);
                            int option;
                            do{
                                System.out.println("Qual a forma de Pagamento: \n1. Pix\n2. Cartão\n3. Dinheiro");
                                option=sc.nextInt();
                                if(option>3||option<1) System.out.println("Opção Invalida");
                            }while (option>3||option<1);
                            Comanda.realizarPagamento(listaPedido,numeroMesa);
                            pagamento.remove(index);
                            mesaOcupada.remove(index);
                            verif2=1;
                            break;
                        }
                        index++;
                    }
                    if (verif2==0){
                        System.out.println("A mesa "+numeroMesa+" não tem pagamentos pendentes\n");
                    }
                    break;
                case 5:
                    if(pagamento.size()>0){
                        System.out.print("\nImposivel finalizar. A(s) mesa(s): ");
                        for (int aux:pagamento) System.out.print("["+aux+"]");
                        System.out.println("  ainda tem pagamentos pendentes!");
                        opcao=0;
                        break;
                    }
                        System.out.println("Finalizando...");
                        Historico.inprimirHistorico();
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }while (opcao!=5);
        sc.close();
    }

}
