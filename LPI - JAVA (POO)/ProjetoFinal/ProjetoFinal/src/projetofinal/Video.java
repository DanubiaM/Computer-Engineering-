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
public class Video implements AcoesVideo{
    private String titulo;
    private int avaliacao;
    private int views;
    private int curtidas;
    private boolean reproduzindo;
    //construtor
    public Video(String titulo){
        this.titulo = titulo;
        this.avaliacao=1;
        this.curtidas=0;
        this.views=0;
        this.reproduzindo = false;
    }
    
    @Override
    public void play(){
        this.reproduzindo = true;
        System.out.println("Video em reprodução!");
    }
    
    @Override 
    public void pause(){
        this.reproduzindo = false;
        System.out.println("Video pausado!");
    }
    
    public void like(){
        this.curtidas ++;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        
        this.avaliacao = (avaliacao + this.avaliacao)/this.views;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public boolean isReproduzindo() {
        return reproduzindo;
    }

    @Override
    public String toString(){
        return "Video{"+"titulo="+titulo+", avalicacao="+ avaliacao+", views="+views+", curtidas="+curtidas+", reproduzindo="+reproduzindo+"}";
    }
    
    
}
