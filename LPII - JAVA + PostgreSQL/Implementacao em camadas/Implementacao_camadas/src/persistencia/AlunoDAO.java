/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import vo.AlunoVO ;
import vo.EnumSexo ;
import vo.EnumUF ;


public class AlunoDAO extends DAO{
    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaMatricula;

    public AlunoDAO( Conexaobd conexao ) throws PersistenciaException{
        super(conexao);
        try{
            comandoIncluir = conexao.getConexao().prepareStatement( "INSERT INTO Aluno ( nome , nomemae , nomepai , sexo , " + " logradouro , numero , bairro , cidade , uf, curso )VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?, ? ) " );
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Aluno SET nome=? , nomemae=? , nomepai=? , sexo=? , " + " logradouro =? , numero=? , bairro =? , cidade =? , uf=?, curso-? WHERE matricula=?" );
            comandoExcluir = conexao.getConexao().prepareStatement( "DELETE FROM Aluno WHERE matricula=?");
            comandoBuscaMatricula = conexao.getConexao().prepareStatement ( "SELECT * FROM Aluno WHERE matricula = ? ");
            
        }catch( SQLException ex ) {
             throw new PersistenciaException(" Erro ao incluir novo aluno − " + ex.getMessage());
        }     
    }

    public int incluir (AlunoVO alunoVO ) throws PersistenciaException {
        int retorno= 0 ;
        Map <String, Integer> listaGrupos = obterGrupoCurso();
        try{
            comandoIncluir.setString(1 , alunoVO.getNome ()) ;
            comandoIncluir.setString ( 2 , alunoVO.getNomeMae ()) ;
            comandoIncluir.setString( 3 , alunoVO.getNomePai ()) ;
            comandoIncluir.setInt(4 , alunoVO.getSexo().ordinal());
            comandoIncluir.setString( 5, alunoVO.getEndereco().getLogradouro());
            comandoIncluir.setInt(6 , alunoVO.getEndereco().getNumero());
            comandoIncluir.setString(7 , alunoVO.getEndereco().getBairro());
            comandoIncluir.setString(8 , alunoVO.getEndereco().getCidade());
            comandoIncluir.setString( 9 , alunoVO.getEndereco().getUf().name());
            comandoIncluir.setInt(10 , listaGrupos.get(alunoVO.getCurso())) ; 
            retorno = comandoIncluir.executeUpdate();
        } catch (SQLException ex){
             throw new PersistenciaException(" Erro ao incluir aluno − " + ex.getMessage());
        }
        return retorno;
     }

    public int alterar(AlunoVO alunoVO ) throws PersistenciaException{
        int retorno = 0; 
       Map <String, Integer> listaGrupos = obterGrupoCurso();

        try{
            comandoAlterar.setString(1, alunoVO.getNome());
            comandoAlterar.setString(2, alunoVO.getNomeMae());
            comandoAlterar.setString(3, alunoVO.getNomePai());
            comandoAlterar.setInt(4, alunoVO.getSexo().ordinal());
            comandoAlterar.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoAlterar.setInt(6, alunoVO.getEndereco().getNumero());
            comandoAlterar.setString(7, alunoVO.getEndereco().getBairro());
            comandoAlterar.setString(8, alunoVO.getEndereco().getCidade());
            comandoAlterar.setString(9, alunoVO.getEndereco().getUf().name());
            comandoAlterar.setInt(10, listaGrupos.get(alunoVO.getCurso()));  
            comandoAlterar.setInt(11, alunoVO.getMatricula());
                     

            retorno = comandoAlterar.executeUpdate();
        }catch(SQLException ex){
            throw new PersistenciaException( "Erro ao alterar o aluno − " + ex.getMessage());
        }
        return retorno;
     }

    public int excluir( int matricula) throws PersistenciaException{
        int retorno= 0;
        try{
            comandoExcluir.setInt (1 ,matricula);
            retorno = comandoExcluir.executeUpdate();
        } catch( SQLException ex){
            throw new PersistenciaException(" Erro ao excluiro aluno − " + ex.getMessage ());

        }
        return retorno;
    }

    public AlunoVO buscarPorMatricula (int matricula) throws PersistenciaException{

        AlunoVO alu =null;
        
        
        try{
            comandoBuscaMatricula.setInt( 1,matricula);
            ResultSet rs = comandoBuscaMatricula.executeQuery();
            if(rs.next()){               
                alu= this.montaAlunoVO(rs);                
            }
        } catch( Exception ex){
            throw new PersistenciaException( " Erro na seleçao por codigo − " + ex.getMessage());
        }
        return alu;
    }

    public List <AlunoVO> buscarPorNome(String nome) throws PersistenciaException {
        List <AlunoVO> listaAluno = new ArrayList<AlunoVO>();
        AlunoVO alu = null;
        String comandoSQL = "SELECT * FROM Aluno WHERE UPPER(nome) LIKE '" + nome.trim().toUpperCase() + "%' ORDER BY NOME LIMIT 10";

        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                alu = this.montaAlunoVO(rs);
                listaAluno.add(alu);
            }
            comando.close();
        }catch( Exception ex){
            throw new PersistenciaException( "Erro na selecao por nome − " + ex.getMessage());
        }
        return listaAluno;
    }

    private AlunoVO montaAlunoVO (ResultSet rs)throws PersistenciaException{
        AlunoVO alu = new AlunoVO();
        if( rs != null){
            try{

                

                alu.setMatricula(rs.getInt("matricula"));
                alu.setNome(rs.getString("Nome").trim());
                alu.setNomeMae(rs.getString("nomemae"));
                alu.setNomePai(rs.getString("nomepai"));
                alu.setSexo(EnumSexo.values()[rs.getInt("sexo")]);
                alu.getEndereco().setLogradouro(rs.getString("logradouro"));
                alu.getEndereco().setNumero(rs.getInt("numero"));
                alu.getEndereco().setBairro(rs.getString("bairro")); 
                alu.getEndereco().setCidade(rs.getString("cidade"));
                //alu.getEndereco().setUf(EnumUF.valueOf(rs.getString("uf")));
                alu.getEndereco().setUf(EnumUF.valueOf(rs.getString("uf").trim()));
                alu.setCurso(obterNomeGrupoCurso(rs.getInt("curso")).trim());

            }catch(Exception ex){
                throw new PersistenciaException(" Erro ao acessar os dados do resultado");
            }
        }
        return alu;
    }

public String obterNomeGrupoCurso(int cod) throws PersistenciaException{
        String nomeGrupo = null;
        PreparedStatement comandoGrupoCurso = null;        
       
        try{
            
            comandoGrupoCurso = conexao.getConexao().prepareStatement("SELECT * FROM Curso WHERE codigo = ?");
            comandoGrupoCurso.setInt(1, cod);
            ResultSet resultado = comandoGrupoCurso.executeQuery();
           
            if(resultado.next()){                
                nomeGrupo = resultado.getString("nome");
            }             
        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao recuperar um grupo" + ex.toString());
        }        
        return nomeGrupo;
    }

    public Map<String, Integer> obterGrupoCurso(){
        Map <String, Integer> listaGrupos = new HashMap();
        PreparedStatement comandoGrupoCurso = null;
        try{
            comandoGrupoCurso = conexao.getConexao().prepareStatement("SELECT * FROM Curso ORDER BY nome");
            ResultSet resultado = comandoGrupoCurso.executeQuery();
            while(resultado.next()){
                listaGrupos.put(resultado.getString("nome").trim(), resultado.getInt("codigo"));
            }
            resultado.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar o grupo de cursos - "+ex.toString());
        }
        return listaGrupos;
    }
    
    public List <AlunoVO> listaAlunos() throws PersistenciaException{
        List <AlunoVO> alunosCadastrados = new ArrayList<AlunoVO>();
        AlunoVO aluno = null;
        String sqlcommand = "SELECT matricula, nome, sexo  FROM Aluno ";
        try{
            
            PreparedStatement comando = conexao.getConexao().prepareStatement(sqlcommand);
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                aluno = montaAluno(rs);
                alunosCadastrados.add(aluno);             
            }
            comando.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar lista de alunos cadastrados - "+ex.toString());
        }       
        
        return alunosCadastrados;
    }

     private AlunoVO montaAluno (ResultSet rs)throws PersistenciaException{
        AlunoVO alu = new AlunoVO();
        if( rs != null){
            try{
                alu.setMatricula(rs.getInt("matricula"));
                alu.setNome(rs.getString("Nome").trim());
                alu.setSexo(EnumSexo.values()[rs.getInt("sexo")]);
            }catch(Exception ex){
                throw new PersistenciaException(" Erro ao acessar os dados do resultado");
            }
        }
        return alu;
    }


    public void listaAlunoDisciplina(String nome) throws PersistenciaException{
        
        
        PreparedStatement comando = null;
        try{
            
            comando = conexao.getConexao().prepareStatement("SELECT Aluno.nome as nomeAluno, Aluno.matricula, Disciplina.codigo, Disciplina.nome as nomeDisciplina\n" +
            "FROM Aluno INNER JOIN Disciplina ON Aluno.curso = Disciplina.curso WHERE UPPER(Aluno.nome)  LIKE '?%'");
            comando.setString(1, nome.toUpperCase());         
            ResultSet rs = comando.executeQuery();            
            System.out.println(">>>LISTA DE DISCIPLINAS DO ALUNO "+nome.toUpperCase()+"<<<");
            while(rs.next()){
                System.out.println("Matricula.................:"+rs.getInt("matricula"));
                System.out.println("Nome do aluno.............:"+rs.getString("nomealuno"));
                System.out.println("Código da Disciplina......:"+rs.getInt("codigo"));
                System.out.println("Nome da Disciplina........:"+rs.getString("nomedisciplina"));
                System.out.println(".......................................");
            }
            comando.close();
        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao acessar disciplinas do aluno");
        }
    } 
}

