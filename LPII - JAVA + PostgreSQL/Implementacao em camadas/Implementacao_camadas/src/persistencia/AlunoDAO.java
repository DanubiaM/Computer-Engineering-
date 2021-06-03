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
import vo.AlunoVO ;
import vo.EnumSexo ;
import vo.EnumUF ;

public class AlunoDAO extends DAO{
    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaMatricula;

    //construtor
    public AlunoDAO(Conexaobd conexao) throws PersistenciaException{

        super(conexao);

        try{
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO ALUNO (nome, nomemae, nomepai, sexo, "+
            "logradouro, numero, bairro, cidade, uf )VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Aluno SET nome=?, nomemae=?, nomepai=?, sexo=?,"+"logragouro=?, numero=?, bairro=?, cidade=?, uf=? WHERE matricula=?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM Aluno WHERE matricula = ?");
            comandoBuscaMatricula = conexao.getConexao().prepareStatement("SELECT * FROM Aluno WHERE matricula = ?");
        }catch(SQLException ex){

            throw new PersistenciaException("Erro ao incluir novo aluno - "+ex.getMessage());
        }
    }

    public int incluir(AlunoVO alunoVO) throws PersistenciaException{
        int retorno = 0;
        try{
            comandoIncluir.setString(1, alunoVO.getNome());
            comandoIncluir.setString(2, alunoVO.getNomeMae());
            comandoIncluir.setString(3, alunoVO.getNomePai());
            comandoIncluir.setInt(4, alunoVO.getSexo().ordinal());
            comandoIncluir.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoIncluir.setInt(6, alunoVO.getEndereco().getNumero());
            comandoIncluir.setString(7, alunoVO.getEndereco().getBairro());
            comandoIncluir.setString(8, alunoVO.getEndereco().getCidade());
            comandoIncluir.setString(9, alunoVO.getEndereco().getUf().name());
            retorno = comandoAlterar.executeUpdate();

        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao alterar o aluno "+ex.getMessage());
        }
        return retorno;
    }

    public int excluir(int matricula) throws PersistenciaException{
        int retorno = 0;
        try{
            comandoExcluir.setInt(1, matricula);
            retorno = comandoExcluir.executeUpdate();
        }catch (SQLException ex){
            throw new PersistenciaException("Erro ao  excluir o aluno - "+ex.getMessage());
        }
        return retorno;
    }

    public AlunoVO buscarPorMatricula(int matricula) throws PersistenciaException{
        AlunoVO alu = null;
        
        try{
            comandoBuscaMatricula.setInt(1, matricula);
            ResultSet rs = comandoBuscaMatricula.executeQuery();

            if( rs.next()){
                alu = this.montaAlunoVO(rs);
            }
        }catch (Exception ex){
            throw new PersistenciaException("Erro na seleção por codigo - "+ ex.getMessage());
        }
        return alu;
    }

    //seria lista pois pode me retornar mais de 1 aluno com o nome
    public List<AlunoVO> buscarPorNome(String nome) throws PersistenciaException {
        List<AlunoVO> listaAluno = new ArrayList();
        AlunoVO alu = null;
    
        String comandoSQL = "SELECT * FROM Aluno WHERE UPPER(nome) LIKE '"+nome.trim().toUpperCase()+"%' ORDER BY NOME LIMIT 10";
        
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                alu = this.montaAlunoVO(rs);
                listaAluno.add(alu);
            }
            comando.close();
        }catch(SQLException ex){
            throw new PersistenciaException("Erro na seleção por nome - "+ex.getMessage());
        }
        return listaAluno;
    }

    //Envia para o alunoVO os dados recebidos do aluno no rs.
    private AlunoVO montaAlunoVO(ResultSet rs ) throws PersistenciaException{
        AlunoVO alu = new AlunoVO();
        if(rs != null){
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
                alu.getEndereco().setUf(EnumUF.valueOf(rs.getString("uf")));

            }catch(Exception ex){
                throw new PersistenciaException("Erro ao acessar os dados do resultado");
            }
        }
        return alu;
    }
}
