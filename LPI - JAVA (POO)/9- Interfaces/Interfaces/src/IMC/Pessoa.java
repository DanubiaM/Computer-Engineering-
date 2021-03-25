/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMC;

/**
 *
 * @author danub
 */
public abstract class Pessoa {
    private float peso;
    private float altura;
    private float imc;
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    protected void setImc(float imc) {
        this.imc = imc;
    }
    
    
}
