/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo3;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author danub
 */
public class FabricadeConexao {
     public static void main(String[] args) {
         Connection  conexao;
         try{
            //Cria  um local unico para conexao com o banco de dados, nao necessitando de criar em varios arquivos
            conexao =FabricaConexao.obterConexao();
            System.out.println("Conexao estabelecida");
            conexao.close();
            System.out.println("Conexao encerrada");
         }catch(SQLException sqle){
                   System.out.println("Conexao nao estabelecida -"+sqle.getMessage());

         
         }
     }
}
