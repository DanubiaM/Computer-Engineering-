/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danub
 */
class FabricaConexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/baseteste";
    private  static final String DRIVE = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    
    public static Connection obterConexao(){
        Connection conexao = null;
        
        try{
            Class.forName(DRIVE);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            
        }catch(ClassNotFoundException cnf){
            System.out.println("Driver nao encontrado - "+cnf.getMessage());
        }catch(SQLException sqle){
            System.out.println("Erro ao conectar ao banco  - "+ sqle.getMessage());
        }
        return conexao;
    }
}
