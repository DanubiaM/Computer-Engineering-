/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animais;

/**
 *
 * @author danub
 */
public class Cachorro extends Mamifero{
    
    public void enterrarOsso(){
        System.out.println("Enterrando osso");
    }
    public void abanarRabo(){
        System.out.println("Abanando rabo");
    }
    
    public void reagir( String fala){
        if(fala == "Ola"){
            System.out.println("Abanar");
        }else if (fala == "Vai apanhar"){
            System.out.println("Rosna");
        }         
    }
    public void reagir(int horas){
        if(horas < 12){
            System.out.println("Abanar");
        }else if( horas > 12){
            System.out.println("Rosna");

        }
    }
}
