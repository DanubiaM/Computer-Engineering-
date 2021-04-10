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
    public Assalariado(int cod, String _nome, Date dataA, String _cargo, String _departamento, float _valorSalario){
        super(cod, _nome, dataA, _cargo, _departamento);
        this.valorSalario = _valorSalario;
    }
    
    @Override
    public void informeRAIS(){
        System.out.println("Código:              "+super.getCodigo());
        System.out.println("Nome:                "+super.getNome());
        System.out.println("Data de Adimissão:   "+super.getDataAdmissao());
        System.out.println("Cargo:               "+super.getCargo());
        System.out.println("Departamento:        "+super.getDepartamento());
        System.out.println("Valor do Salário:    "+this.valorSalario);
    }
    public float getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(float valorSalario) {
        this.valorSalario = valorSalario;
    }  
    
    
}
