/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author danub
 */
public class Visualizacao {
    private Gafanhoto espectador;
    private Video filme;
    
    public Visualizacao(Gafanhoto _espectador, Video _filme){
      this.espectador = _espectador;
      this.filme = _filme;
      this.espectador.viuMaisUm();
      this.filme.setViews(this.filme.getViews()+1);
    }
    //sobrecarga de método
    public void avaliar(){
        System.out.println("Avaliado");
        filme.setAvaliacao(1);
    }
    public void avaliar(int nota){
        System.out.println("Avaliado");
        filme.setAvaliacao(nota);
    }
    public void avaliar(float porc){
        System.out.println("Avaliado");
        
        filme.setAvaliacao((int)porc);
    }
    
    @Override
    public String toString(){
        return "Visualizacao{"+"espectador="+espectador+", filme"+ filme+"}";
    }
}
