
package Exemplo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoPropietaria {
    public static void main(String[] args) throws IOException{
        
        Properties proDB = new Properties();
        //String de leitura de arquivos
        FileInputStream leitorArquivo;
        
        //Parte que faz o carregamento do arquivo e verifica possiveis erros
        try{
            leitorArquivo = new FileInputStream("conexao.properties");
            proDB.load(leitorArquivo);
            leitorArquivo.close();
        }catch(FileNotFoundException ex){
            System.out.println("Arquivo de configuracao nao encontrado - "+ex.getMessage());
        }catch(IOException ex){
            System.out.println("Erro ao ler arquivo de configuracoes - "+ex.getMessage());
        }
        //Faz a conexão com o Drive e verifica erros possiveis do BD e Drive        
        if(!proDB.isEmpty()){
            Connection conexao;
            //Faz a carga das propriedades do arquivo
            String url = proDB.getProperty("url");
            String driver = proDB.getProperty("driver");
            String usr = proDB.getProperty("usuario");
            String pass = proDB.getProperty("senha");
            try{
                Class.forName(driver);
                conexao = DriverManager.getConnection(url,usr,pass);
                System.out.println("Conexao estabelecida");
                conexao.close();
                System.out.println("Conexao encerrada");
            }catch(ClassNotFoundException cnf){
                System.out.println("Driver nao encontrado - "+cnf.getMessage());
                
            }catch(SQLException sqle){
                System.out.println("Banco nao conectado -"+sqle.getMessage());
            }
        }else{
            System.out.println("Propriedades nao carregadas");
        }
    }
}
