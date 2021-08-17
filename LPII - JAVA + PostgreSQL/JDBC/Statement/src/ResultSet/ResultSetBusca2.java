/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danub
 */
public class ResultSetBusca2 {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        PreparedStatement comando = null;
        
        String nome = JOptionPane.showInputDialog("Digite parte do nome do produto");
        try{
            comando = conexao.prepareStatement("SELECT * FROM grupoproduto  WHERE upper(nome) LIKE ?");
            comando.setString(1,"%"+ nome.toUpperCase()+ "%");
            ResultSet resultado = comando.executeQuery();
            if(resultado.next()){
                do{
                    System.out.println("Codigo:             "+ resultado.getInt("codigo"));                   
                    System.out.println("Nome:               "+ resultado.getString("nome"));
                    System.out.println("% Promocao:         "+ resultado.getFloat("promocao"));
                    System.out.println("% Margem Lucro:     "+ resultado.getFloat("margemlucro"));
                    System.out.println("------------------------------------------------------");
                }while(resultado.next());
            }else{
                System.out.println("Não encontrado");
            }
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar um grupo "+ ex.toString());
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
