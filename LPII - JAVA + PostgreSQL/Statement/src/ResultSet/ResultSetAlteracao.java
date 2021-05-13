/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danub
 */
public class ResultSetAlteracao {
    
    public static void main(String[] args){
     Connection conexao = FabricaConexao.obterConexao();
     PreparedStatement comando = null;
     
     int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o codigo do produto a ser alterado"));
     float promocao = Integer.parseInt(JOptionPane.showInputDialog("Forneça o valor da promocao"));
     float margem = Integer.parseInt(JOptionPane.showInputDialog("Forneça o valor da margem do lucro"));

     try{
         comando = conexao.prepareStatement("UPDATE grupoproduto SET promocao=?, margemlucro=? WHERE codigo=?");
         comando.setFloat(1,promocao);
         comando.setFloat(2, margem);
         comando.setInt(3, codigo);
         
         int conRec = comando.executeUpdate();
         System.out.println("Alteracao realizada com sucesso");
         System.out.println("Numeros de registros alterados "+conRec);
     }catch(SQLException ex){
         System.out.println("Erro ao alterar o grupo " + ex.toString());
     }finally{
         try{
             conexao.close();
             comando.close();
         }catch(SQLException ex){
             System.out.println("Erro ao encerrar " +ex.toString());
         }
     }
    }   
}
