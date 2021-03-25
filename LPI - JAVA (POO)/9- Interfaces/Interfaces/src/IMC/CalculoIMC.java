/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMC;

import java.util.Scanner;

/**
 *
 * @author danub
 */
public class CalculoIMC {
    
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        int opcao = -1;
        
        do{
           System.out.println("CALCULO DE IMC");
           System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
           System.out.println("INFORME");
           System.out.println("[1] CALCULAR IMC MASCULINO");
           System.out.println("[2] CALCULAR IMC FEMININO");
           System.out.println("[0] SAIR");
           opcao = scanf.nextInt();
           if(opcao == 1){

           }else if (opcao == 2){
               
           }            
        }while(opcao != 0);
        
    }
    
}
