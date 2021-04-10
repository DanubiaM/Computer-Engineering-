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
public class Horista extends Empregado{
    private float valorHora;

    public Horista(int cod, String _nome, Date dataA, String _cargo, String _departamento, float _valorHora){
        super(cod, _nome, dataA, _cargo, _departamento);
        this.valorHora = _valorHora;
    }
    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }
    @Override
    public String toString(){
        return "Horista= Codigo: "+ super.getCodigo()+ ", Nome: "+super.getNome()+", Data de Adimissão"+super.getDataAdmissao()+", Cargo: "+super.getCargo()+", Departamento: "+super.getDepartamento()+", Valor Hora:"+this.valorHora;
    }
}
