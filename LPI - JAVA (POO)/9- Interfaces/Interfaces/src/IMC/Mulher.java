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
public class Mulher extends Pessoa implements IAptoCalcularIMC{
    public void calcularIMC(){
        float imc = 0;
        float peso = this.getPeso();
        float altura = this.getAltura();
        imc = peso / (altura*altura);
        this.setImc(imc);
    }
    
}
