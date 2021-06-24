

package vo;

/**
 *
 * @author danub
 */
public class DisciplinaVO {

    private int codigo;
    private String nome;
    private int semestre;
    private int cargahoraria;
    private String curso;

    public DisciplinaVO(){
        this.codigo =0;
        this.nome="";
        this.semestre =0;
        this.cargahoraria =0;
        this.curso="";
    }
    public DisciplinaVO(String nome, int semestre, int cargahoraria, String curso){
        this();
        this.nome = nome;
        this.semestre = semestre;
        this.cargahoraria = cargahoraria;
        this.curso = curso;
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
    public int getSemestre(){
        return this.semestre;
    }
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    public int getCargaHoraria(){
        return this.cargahoraria;
    }
    public void setCargaHoraria(int cargahoraria){
        this.cargahoraria = cargahoraria;
    }
    public String getCurso(){
        return this.curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }
    @Override
    public String toString(){
      return codigo+" , "+ nome +", "+ semestre+", "+cargahoraria+", "+curso;  
    }


}
