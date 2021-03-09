
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int Id;
    private Date Data;
    private String NomeCliente;
    private float ValorTotal;
    private List<Item> Itens;
   
    /*Construtor*/
    public Pedido(){
        Itens = new ArrayList<Item>();
    }
    
    /*Métodos acessores*/
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
    public Date getData() {
        return Data;
    }
    public void setData(Date data) {
        this.Data = data;
    }
    public String getNomeCliente() {
        return NomeCliente;
    }
   public void setNomeCliente(String nomeCliente) {
        this.NomeCliente = nomeCliente;
    }
    public float getValorTotal() {
        return ValorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.ValorTotal = valorTotal;
    }
 /*Sobrecarga de método*/
    public void addProduto(Produto produto, int quantidade, float valorUnitario ){
           Item item = new Item();
           item.setItemId(1);
           item.setProduto(produto);
           item.setQuantidade(quantidade);
           item.setValorUnitario(valorUnitario);
           Itens.add(item);
           calcularValorTotal();
    }
    
    public  void addProduto(int produtoId, String descricaoProduto, float valorPadrao, int quantidade, float valorUnitario){
        Produto produto = new Produto();
        produto.setId(produtoId);
        produto.setDescricao(descricaoProduto);
        produto.setValorPadrao(valorPadrao);
        this.addProduto(produto,quantidade, valorUnitario);
    }
    /*Sobrecarga de método*/
    public void delProduto(Item item){
        Itens.remove(item);
        calcularValorTotal();
    }
    public void delProduto(int produtoId){
        for(Item i: Itens){
            if(i.getProduto().getId() == produtoId){
                delProduto(i);
                break;
            }
        }
    }
    private void calcularValorTotal(){
        float valorTotal = 0;
        for(Item i: Itens){
            valorTotal += i.getValorTotal();
        } 
        this.setValorTotal(valorTotal);
    }
}
