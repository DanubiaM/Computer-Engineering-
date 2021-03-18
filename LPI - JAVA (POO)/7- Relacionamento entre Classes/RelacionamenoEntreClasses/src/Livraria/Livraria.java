/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author danub
 */
public class Livraria {


    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
    
        Pessoa [] pessoas = new Pessoa[2];
        Livro [] livros =  new Livro[2];
        
        pessoas[0] = new Pessoa("Jose Eduardo", 19, "Masculino");
        pessoas[1] = new Pessoa("Daniele",25, "Feminino");
        
        livros[0] = new Livro("Html + CSS", "Jon Ducker", 250, pessoas[1]);
        livros[1] = new Livro("JavaScript + Jquerry", "Jon Ducker", 300, pessoas[0]);
        
        livros[1].abrir();
        livros[1].detalhes();
        livros[1].folhear(7);
        livros[1].voltarPag();
        livros[1].detalhes();
    }
   
}
