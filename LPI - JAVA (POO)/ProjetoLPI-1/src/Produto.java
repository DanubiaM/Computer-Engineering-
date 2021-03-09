
public class Produto {
    private int Id;
    private String Descricao;
    private float ValorPadrao;
    
    public void setId(int _id){
        this.Id = _id;
    }
    public int getId(){
        return this.Id;
    }
    public void setDescricao(String _descricao){
        this.Descricao = _descricao;
    }
    public String getDescricao(){
        return this.Descricao;
    }
    public void setValorPadrao(float _valorPadrao){
        this.ValorPadrao = _valorPadrao;
    }
    public float getValorPadrao(){
        return this.ValorPadrao;
    }
    
}
