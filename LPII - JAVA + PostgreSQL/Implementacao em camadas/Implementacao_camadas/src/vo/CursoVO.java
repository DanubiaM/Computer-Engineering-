package vo;

/**
 *
 * @author danub
 */
public class CursoVO {

    private int codigo;
    private String nome;
    private String descricao;

    public CursoVO(){
        this.codigo = 0;
        this.nome = "";
        this.descricao = "";
        
    }

    public CursoVO(int codigo, String nome, String descricao){
        this(); // Para inicializar com os valores padrão apresentados no construtor acima.
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;

    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
 }   
