
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danub
 */
public class Pedido {
    private int id;
    private Date data;
    private String nomeCliente;
    private float valorTotal;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
   public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
