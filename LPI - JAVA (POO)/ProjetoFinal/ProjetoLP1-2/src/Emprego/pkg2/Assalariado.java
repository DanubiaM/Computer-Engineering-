/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprego.pkg2;

import java.util.Date;

/**
 *
 * @author danub
 */
public class Assalariado extends Empregado implements ICeletista{
    private float valorSalario;

    //construtor
    public Assalariado(int cod, String _nome, Date dataA, String _cargo, String _departamento){
        super(cod, _nome, dataA, _cargo, _departamento);
    }
    
    @Override
    public void informeRAIS(){
        
    }
    public float getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(float valorSalario) {
        this.valorSalario = valorSalario;
    }

    
    
    
}
