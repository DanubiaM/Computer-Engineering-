/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statement;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
/**
 *
 * @author danub
 */
public class StatementTeste {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        Statement comando = null;
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de margem de lucro do grupo de produto"));
        String sql = "INSERT INTO grupoproduto (nome, promocao, margemlucro) VALUES ";
        sql += "('"+nome+"', "+promocao+", "+margem+")";
        try{
            comando = conexao.createStatement();
            comando.executeUpdate(sql);
            System.out.println("Inclusao realizada com sucesso!");
        }catch(SQLException ex){
            System.out.println("Erro ao incluir grupo - "+ ex.getMessage());
        } finally {
            try{
                comando.close();
                conexao.close();
            }catch(SQLException ex){
                System.out.println("Erro ao desconectar "+ ex.getMessage());
            }
        }
        }

    private void executeUpdate(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
