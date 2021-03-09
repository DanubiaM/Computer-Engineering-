
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

    public static void main(String[] args) throws ParseException{
        List<Produto> lista = new ArrayList<Produto>();  
        List<Pedido> listaPedido = new ArrayList<Pedido>();
        Scanner scanf = new Scanner(System.in);
        
//        for(int i =0; i<=2; i++){
//            Produto p = new Produto();
//            System.out.println("ID:");
//            p.setId(scanf.nextInt()); //Também posso criar a variavel para receber o scanf.
//            System.out.println("Descrição:");
//            p.setDescricao(scanf.next());
//            System.out.println("Valor Padrão:");
//            p.setValorPadrao(scanf.nextFloat());
//            lista.add(p);
//        }
//        
//         System.out.println("\n\nDados digitados:");
//        for(Produto p : lista){ // A variavel recebe todos os valores da lista que é do tipo Produto
//            System.out.print("Id");
//            System.out.println(p.getId());
//            System.out.print("Descrição:");
//            System.out.println(p.getDescricao());
//            System.out.print("Valor:");
//            System.out.println(p.getValorPadrao());
//        }
//        
//    
//          Para Pedidos
        System.out.println("Por favor, entre com os dados do pedido: \n");
        for(int i = 0; i<=2; i++){
            Pedido pedido = new Pedido(); // A cada laço ele vai instanciar um novo objeto pedido
            System.out.println("Id:");
            pedido.setId(scanf.nextInt());
            System.out.println("Data:");    
            // Utilização de bibliotecas para formatar data.
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");           
            String data = scanf.next();            
            Date dataFormatada = formato.parse(data);               
            
            pedido.setData(dataFormatada);
            
            System.out.println("Valor Total:");
            pedido.setValorTotal(scanf.nextFloat()); 
            
            listaPedido.add(pedido); //Por fim vai adicionar na listaPedido
        }
        System.out.println("\n\nLista de Pedidos:");
        for(Pedido p : listaPedido){
            System.out.print("Id:");
            System.out.println(p.getId());
            System.out.print("Data:");
            System.out.println(p.getData());
            System.out.print("Valor Total:");
            System.out.println(p.getValorTotal());
        }
    }
}
