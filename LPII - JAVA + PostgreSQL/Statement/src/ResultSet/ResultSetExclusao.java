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
public class ResultSetExclusao {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        PreparedStatement comando = null;
        
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o codigo do grupo a ser exlcuido"));
        
        try{
            comando = conexao.prepareStatement("DELETE FROM grupoproduto WHERE codigo=?");
            comando.setInt(1,codigo);
            
            int contRec = comando.executeUpdate();
            System.out.println("Exclusao realizada com sucesso [ "+contRec+" excluido ]");
        }catch(SQLException ex){
            System.out.println("Erro ao excluir grupo do produto "+ex.toString());
        }finally{
            try{
                conexao.close();
                comando.close();
            }catch(SQLException ex){
                System.out.println("Erro ao desconectar "+ex.toString());
            }
            
        }
    }
}
