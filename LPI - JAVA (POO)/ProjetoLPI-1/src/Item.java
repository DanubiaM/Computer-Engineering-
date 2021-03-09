/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danub
 */
public class Item {
    private int ItemId;
    private Produto Produto;
    private int Quantidade;
    private float ValorUnitario;
    private float ValorTotal;
    
    /*Métodos acessores*/
    public int getItemId() {
        return this.ItemId;
    }
    public void setItemId(int id){
        this.ItemId = id;
    }
    
    public Produto getProduto(){
        return this.Produto;
    }
    public void setProduto(Produto produto){
        this.Produto = produto;
    }
    public int getQuantidade(){
        return this.Quantidade;
    }
    public void setQuantidade(int quantidade){
        this.Quantidade = quantidade;
        this.calculaValorTotal();
    }
    public float getValorUnitario(){
        return this.ValorUnitario;
    }
    public void setValorUnitario(float valorUnitario){
        this.ValorUnitario = valorUnitario;
        this.calculaValorTotal();
    }
    public float getValorTotal(){
        return this.ValorTotal;
    }
    private void setValorTotal(float valorTotal){
        this.ValorTotal = valorTotal;
    }
    private void calculaValorTotal(){
        float quantidade = getQuantidade();
        float valorUnitario = getValorUnitario();
        float valorTotal = 0;
        if(quantidade > 0 && valorUnitario > 0){
            valorTotal = quantidade * valorUnitario;
        }
        setValorTotal(valorTotal);
    }
}
