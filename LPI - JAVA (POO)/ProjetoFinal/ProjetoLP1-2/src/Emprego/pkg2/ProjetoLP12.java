/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprego.pkg2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author danub
 */
public class ProjetoLP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        //Para transformadas uma string em data
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        
        //realizando testes
        
        Horista h = new Horista(15, "Joao", dataFormatada.parse("15/12/2001") , "Medico", "Cirurgia Geral", 700);
        System.out.println(h.toString());
        
        Comissionado c = new Comissionado(001, "Maria", dataFormatada.parse("11/01/2007"), "Vendedor", "Varejo", 40);
        System.out.println(c.toString());
        
        Assalariado  a = new Assalariado(17, "Jose", dataFormatada.parse("20/04/2009"), "Engenheiro civil", "Infraestrutura metalica", 7500);
        a.informeRAIS();
    }
    
}
