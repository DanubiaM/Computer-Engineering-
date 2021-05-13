/*
  SITUASÇÃO DE USO DE RETORNO DE CHAVE:

    Imagine que em banco de produção a todo momento seja inserido grupo de dados, para você observar o seu grupo de dado após a sia inserção pode ser uma tarefa complicada.
    Imagine então, que apos a inserção voce deseja visualizar a chave do grupo inserido, com diversos grupos sendo criado a todo momento, essa tarefa se torna complicada,
    para isso foi criado  a inserção com o retorno da chave primaria.
 */
package Retorno_de_Chave;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ReturnKey {
    public static void main(String args[]){
        Connection conexao = FabricaConexao.obterConexao();
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de margem de lucro do grupo de produto"));
        try{
            String sql = "INSERT INTO grupoproduto (nome, promocao, margemlucro) VALUES (?, ?, ?)";
            //solicitação do retono da chave
            comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, nome);
            comando.setFloat(2, promocao);
            comando.setFloat(3, margem);

            ResultSet rs = comando.getGeneratedKeys();
            long chave = 0;
            if(rs.next()){
                chave = rs.getLong("codigo");

            }
            System.out.println("Inclusao realizada com suceso: ["+chave+"]");
        }catch(SQLException ex){
            System.out.println("Erro ao incluri grupo do produto - "+ ex.getMessage());
        } finally {
            try{
                comando.close();
                conexao.close();
            }catch(SQLException ex){
                System.out.println("Erro ao desconectar "+ ex.getMessage());
            }
        }
        
    }    
}
