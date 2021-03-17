/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamenoentreclasses;

import java.util.Random;

/**
 *
 * @author danub
 */
public class Luta {

    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    
    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
    public  void marcarLuta(Lutador lutador_1, Lutador lutador_2){
        if(lutador_1.getCategoria() ==  lutador_2.getCategoria()){
            if(lutador_1.getNome() != lutador_2.getNome()){
                setDesafiado(lutador_1);
                setDesafiante(lutador_2);
                setAprovada(true);
            }else{
                setDesafiado(null);
                setDesafiante(null);
                setAprovada(false);
            }
        }
        
    }
    public void lutar(){
        if(isAprovada() == true){
            getDesafiado().apresentar();
            getDesafiante().apresentar();
            Random gerador = new Random();
            int vencedor = gerador.nextInt(2);
            
            switch(vencedor){
                case 0 -> {
                    System.out.println("Luta empatada");
                    getDesafiado().empatarLuta();
                    getDesafiante().empatarLuta();
                }
                case 1 ->{
                    System.out.println("Ganhou "+ getDesafiado().getNome());
                    getDesafiado().ganharLuta();
                    getDesafiante().perderLuta();
                }
                case 2 ->{
                    System.out.println("Ganhou "+ getDesafiante().getNome());
                    getDesafiado().perderLuta();
                    getDesafiante().ganharLuta();
                }
             }
        }else{
            System.out.println("Luta não aprovada!");
        }
    }
    
}
