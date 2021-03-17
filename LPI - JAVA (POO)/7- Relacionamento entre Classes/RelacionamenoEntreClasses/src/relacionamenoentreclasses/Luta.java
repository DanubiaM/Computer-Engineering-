/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamenoentreclasses;

/**
 *
 * @author danub
 */
public class Luta {

    /**
     * @return the desafiado
     */
    public Lutador getDesafiado() {
        return desafiado;
    }

    /**
     * @param desafiado the desafiado to set
     */
    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    /**
     * @return the desafiante
     */
    public Lutador getDesafiante() {
        return desafiante;
    }

    /**
     * @param desafiante the desafiante to set
     */
    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    /**
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @param rounds the rounds to set
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * @return the aprovada
     */
    public boolean isAprovada() {
        return aprovada;
    }

    /**
     * @param aprovada the aprovada to set
     */
    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    
    
    
}
