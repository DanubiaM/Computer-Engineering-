/*
    Classe responsavel por transportar os dados entre as camadas, representando uma entidade aluno
 */

package vo;
public class AlunoVO {
    private int matricula;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private EnumSexo sexo;
    private EnderecoVO endereco;

    //construtor
    public AlunoVO(){
        this.endereco = new EnderecoVO();
        this.matricula = 0;
        this.nomeMae = "";
        this.nomePai = "";
        this.sexo = EnumSexo.FEMENINO;
    
    }

    public AlunoVO(int matricula, String nome, EnumSexo sexo){
        this();
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getMatricula(){
        return matricula;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
   public String getNomePai(){
        return nomePai;
    }
    public void setNomePai(String  nomePai){
        this.nomePai = nomePai;
    }
   public String getNomeMae(){
        return nomeMae;
    }
    public void setNomeMae(String  nomeMae){
        this.nomeMae = nomeMae;
    }
   public EnumSexo getSexo(){
        return sexo;
    }
    public void setSexo(EnumSexo sexo){
        this.sexo = sexo;
    }

   public EnderecoVO getEndereco(){
        return endereco;
    }
    public void setEndereco(EnderecoVO endereco){
        this.endereco = endereco;
    }
    
    @Override
    public String toString(){
        return  matricula+", "+ nome +", "+ sexo +",residente em: "+ endereco;
    }
}
