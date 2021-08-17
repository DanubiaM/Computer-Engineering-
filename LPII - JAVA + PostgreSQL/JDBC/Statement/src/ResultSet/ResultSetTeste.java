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
public class ResultSetTeste {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        PreparedStatement comando = null;
    
               
        try{
            comando = conexao.prepareStatement("SELECT * FROM grupoproduto ORDER BY nome");
            //Metodo executeQuery() é o responsavel por retornar um objeto do tipoResultSet
            ResultSet  resultado = comando.executeQuery();
            
            while(resultado.next()){                
                System.out.println("Codigo:             "+ resultado.getInt("codigo"));                   
                System.out.println("Nome:               "+ resultado.getString("nome"));
                System.out.println("% Promocao:         "+ resultado.getFloat("promocao"));
                System.out.println("% Margem Lucro:     "+ resultado.getFloat("margemlucro"));
                System.out.println("------------------------------------------------------");

            }
            resultado.close();
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
