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
               calcularIMCHomem();
           }else if (opcao == 2){
               calcularIMCMulher();
           }            
        }while(opcao != 0);
        
    }
    private static void calcularIMCHomem(){
        Homem homem = new Homem();
        fillDadosPessoa(homem);
        imprimirDadosIMC(homem);
    }
    private static void calcularIMCMulher(){
        Mulher mulher = new Mulher();
        fillDadosPessoa(mulher);
        imprimirDadosIMC(mulher);
    }
    private static void fillDadosPessoa(Pessoa pessoa){
        Scanner scanf = new Scanner(System.in);
        System.out.println("Informe a altura: ");
        pessoa.setAltura(scanf.nextFloat());
        System.out.println("Informe o peso: ");
        pessoa.setPeso(scanf.nextFloat());
    }
    
    private static void imprimirDadosIMC(IAptoCalcularIMC apto){
        System.out.println("DADOS DO IMC");
        System.out.println("-=-=-=-=-=-=-=-");
        apto.calcularIMC();
        Pessoa pessoa = (Pessoa)apto; //conversao do apto para pessoa
        if( pessoa instanceof Homem){
            System.out.println("A pessoa é um homem."); // USO DE CAST
            System.out.println("Peso"+ Float.toString(((Homem)apto).getPeso())); //link https://www.guj.com.br/t/cast/90744/5 para entender melhor!
            System.out.println("Altura"+ Float.toString(((Homem)apto).getAltura()));
            System.out.println("IMC"+ Float.toString(((Homem)apto).getImc()));
        } 
        if(pessoa instanceof Mulher){
            System.out.println("A pessoa é uma mulher.");
            System.out.println("Peso"+ Float.toString(((Mulher)apto).getPeso()));
            System.out.println("Altura"+ Float.toString(((Mulher)apto).getAltura()));
            System.out.println("IMC"+ Float.toString(((Mulher)apto).getImc()));
        }

    }
}
