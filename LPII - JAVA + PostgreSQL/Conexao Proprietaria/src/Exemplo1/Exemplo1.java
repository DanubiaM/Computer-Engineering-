
package Exemplo1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exemplo1 {

  public static void main(String[] args) {
      Connection conexao;
      String url = "jdbc:postgresql://localhost:5432/baseteste";
      String usr= "postgres";
      String pass= "postgres";
      try{
          Class.forName("org.postgresql.Driver");
          conexao = DriverManager.getConnection(url, usr, pass);
          System.out.println("Conexao estabelecida");
          conexao.close();
          System.out.println("Conexao encerrada");
      }catch(ClassNotFoundException cnf){
          System.out.println("Classe do driver não encontrada - "+cnf.getMessage());
      }catch(SQLException sqle){
          System.out.println("Conexao nao estabelecida -"+sqle.getMessage());
      }
  }
}
