/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danub
 */
public class PreparedStatementTeste {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog("Forneça o nome do grupo do produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneça  o pocentual de promocao  do grupo do produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneça  o pocentual da margem de lucro  do grupo do produto"));

        try{
            comando = conexao.prepareStatement("INSERT INTO grupoproduto (nome, promocao, margemlucro) VALUES (?, ?, ?)");
            comando.setString(1,nome);
            comando.setFloat(2, promocao);
            comando.setFloat(3, margem);
            comando.executeUpdate();
            System.out.println("Inclusao realizada com sucesso");
            
        }catch(SQLException ex){
            System.out.println("Erro ao incluir grupo de produto "+ ex.toString());
        
        }finally{
            try{
                comando.close();
                conexao.close();
            }catch(SQLException ex){
                            System.out.println("Erro ao desconectar "+ ex.toString());

            }
        }
    }
}
