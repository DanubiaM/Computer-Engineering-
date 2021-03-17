/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamenoentreclasses;

/**
 *
 * @author danub
 */
public class UltraEmojiCombat {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lutador lutadores[] = new Lutador[6];
        
        lutadores[0] = new Lutador("Pretty Boy", "França", 31, 1.75f, 68.9f, 11, 2, 1);
        lutadores[1] = new Lutador("Popo", "Brasil", 41, 1.56f, 79.8f, 14, 4, 5);
        lutadores[2] = new Lutador("Kill hot", "EUA", 28, 1.98f, 88.8f, 4, 0, 3);
        lutadores[3] = new Lutador("ET Valet", "Italia",37, 2.10f, 100.8f, 8, 2, 4);
        lutadores[4] = new Lutador("Spark", "Gracia", 41, 2.06f, 99.4f, 4, 2, 2);
        lutadores[5] = new Lutador("Añtonito", "Mexico", 41, 1.99f, 79.2f, 11, 4, 1);
        
       Luta UEC01 = new Luta();
       UEC01.marcarLuta(lutadores[3], lutadores[2]);
       UEC01.lutar();
        
        
    }
    
}
