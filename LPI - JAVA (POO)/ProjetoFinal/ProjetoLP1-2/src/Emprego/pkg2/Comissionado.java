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
public class Comissionado extends Empregado{
    private float porcentualComissao;

    public Comissionado(int cod, String _nome, Date dataA, String _cargo, String _departamento){
        super(cod, _nome, dataA, _cargo, _departamento);

    }
    public float getPorcentualComissao() {
        return porcentualComissao;
    }

    public void setPorcentualComissao(float porcentualComissao) {
        this.porcentualComissao = porcentualComissao;
    }
    
    
}
