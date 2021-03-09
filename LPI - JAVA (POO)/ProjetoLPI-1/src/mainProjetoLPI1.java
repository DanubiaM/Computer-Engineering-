
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author danub
 */
public class mainProjetoLPI1 {
    
    public static final List<Produto> listaProduto = new ArrayList<Produto>();
    public static final List<Pedido> listaPedido = new ArrayList<Pedido>();
    
    public static void main(String[] args) throws ParseException{
        Scanner scanf = new Scanner(System.in);
        
        int opcao = 0;
        
        do{
            System.out.println("-- SISTEMA FRENTE DE CAIXA --");
            System.out.println("------------------------------");
            System.out.println("Selecione a opção desejada: ");
            System.out.println(" [0] Acessar Produtos");
            System.out.println(" [1] Acessar Pedidos");
            System.out.println(" [2] Sair");
            opcao = scanf.nextInt();
            if(opcao == 0){
                acessarProduto();
            }else if(opcao == 1){
                acessarPedido();
            }
        }while(opcao != 2);
        
    }
    public static void acessarProduto(){
        Scanner scanf = new Scanner(System.in);
        
        int opcao = 0;
        do{
            System.out.println("-- Lançamento de PRODUTO --");
            System.out.println("---------------------------");
            System.out.println("Informe:");
            System.out.println(" [1] Lançar novo Produto");
            System.out.println(" [2] Listar Produto realizados");
            System.out.println(" [3] Remover Produto");
            System.out.println(" [4] Sair");
            System.out.println("Opcao:");
            opcao = scanf.nextInt();
            switch (opcao){
                case 1 -> {
                    System.out.println("Id: ");
                    int id = scanf.nextInt();
                    System.out.println("Descrição: ");
                    String descricao = scanf.next();
                    System.out.println("Valor Padrão: ");
                    float valorP = scanf.nextFloat();
                    addProduto(id, descricao, valorP);
                    break;
                }
                case 2 ->{
                    if(listaProduto.size() == 0){
                        System.out.println("Não existe Produto lançados");
                    }else{
                        System.out.println("\t\t\tProdutos:");
                        for(Produto p : listaProduto){
                            System.out.println("Id       :    "+Integer.toString(p.getId()));
                            System.out.println("Descrição:    "+p.getDescricao());
                            System.out.println("Valor Padrão: "+ Float.toString(p.getValorPadrao()));
                        }
                        System.out.println("------------------------------------------------------");
                    }
                    break;
                }
                case 3 ->{
                    System.out.println("REMOÇÃO DE PRODUTO!!");
                    System.out.println("Informe o ID do produto: ");
                    int id = scanf.nextInt();
                    for(Produto p: listaProduto){
                        if(p.getId() == id){
                            String descricao = p.getDescricao();
                            listaProduto.remove(p);
                            System.out.println("Produto "+ descricao + "removido com sucesso!" );
                            break;
                        }
                    }
                    break;
                }
            }            
        }while(opcao != 4);
    }
    public static void acessarPedido(){
        Scanner scanf = new Scanner(System.in);
        
        int opcao = 0;
        do{
            System.out.println("-- Lançamento de Pedido --");
            System.out.println("---------------------------");
            System.out.println("Informe:");
            System.out.println(" [1] Lançar novo Pedido");
            System.out.println(" [2] Listar Pedidos realizados");
            System.out.println(" [3] Remover Pedido");
            System.out.println(" [4] Sair");
            System.out.println("Opcao:");
            opcao = scanf.nextInt();
            switch (opcao){
                case 1 -> {
//                    System.out.println("Id: ");
//                    int id = scanf.nextInt();
//                    System.out.println("Descrição: ");
//                    String descricao = scanf.next();
//                    System.out.println("Valor Padrão: ");
//                    float valorP = scanf.nextFloat();
//                    addPedido(id, descricao, valorP);
//                    break;
                }
                case 2 ->{
                    if(listaPedido.size() == 0){
                        System.out.println("Não existe Pedidos lançados");
                    }else{
                        for(Pedido p : listaPedido){
//                            System.out.println("Id       : "+Integer.toString(p.getId()));
//                            System.out.println("Descrição: "+p.getDescricao());
//                            
                              System.out.println("------------------------------------------------------");
                        }
                    }
                    break;
                }
                case 3 ->{
                    System.out.println("REMOÇÃO DO PEDIDO");
                    System.out.println("Informe o ID");
                    int id = scanf.nextInt();
                    for(Pedido p : listaPedido){
                        if(p.getId() == id){
                            listaPedido.remove(p);
                        }
                    }
                    break;
                }
            }    
        }while(opcao != 4);
        
    }
        public static void addProduto(Produto newProduto){
            listaProduto.add(newProduto);
        }
        public static void addProduto(int id, String descricao, float valorPadrao){
            Produto newProduto = new Produto();
            newProduto.setId(id);
            newProduto.setDescricao(descricao);
            newProduto.setValorPadrao(valorPadrao);
            addProduto(newProduto);
        }
        
        public static void addPedido(Pedido newPedido){
            listaPedido.add(newPedido);
        }
        
        
    
}
