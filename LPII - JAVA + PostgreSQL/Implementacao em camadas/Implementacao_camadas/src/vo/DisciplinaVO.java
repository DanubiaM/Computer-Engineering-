

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

    private int getCodigo(){
        return this.codigo;
    }
    private void setCodigo(int codigo){
        this.codigo = codigo;
    }
    private String getNome(){
        return this.nome;
    }
    private void setNome(String nome){
        this.nome = nome;
    }
    private int getSemestre(){
        return this.semestre;
    }
    private void setSemestre(int semestre){
        this.semestre = semestre;
    }
    private int getCargaHoraria(){
        return this.cargahoraria;
    }
    private void setCargaHoraria(int cargahoraria){
        this.cargahoraria = cargahoraria;
    }
    private String getCurso(){
        return this.curso;
    }
    private void setCurso(String curso){
        this.curso = curso;
    }
    @Override
    public String toString(){
      return codigo+" , "+ nome +", "+ semestre+", "+cargahoraria+", "+curso;  
    }


}
