/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

/**
 *
 * @author Thibaud
 */
//Convertis les data affiché sur la console en float exploitable par la régulation
public class Conversion {

    public static float moyenneinterieur;
    public static float moyenneexterieur;
    public static float moyennehumidite;

    static float sommeinterieur;
    static float sommeexterieur;
    static float sommehumidite;
    
    public static float interieur;
    public static float exterieur;
    public static float humidite;
    

    public static float[] conversion(int[] statistiques, int compteur) {
        interieur = statistiques[0] / 100;
         exterieur = statistiques[2] / 100;
         humidite = statistiques[1] / 100;

        //Les moyennes s'incremente en même temps que le compteur pour lisser les résultats
        sommeinterieur = sommeinterieur + interieur;
        sommeexterieur = sommeexterieur + exterieur;
        sommehumidite = sommehumidite + humidite;

        //Une fois suffisament de relevé fait lissage des résultats
        if (compteur > 14) {
            moyenneinterieur = sommeinterieur / compteur;
            moyenneexterieur = sommeexterieur / compteur;
            moyennehumidite = sommehumidite / compteur;
            System.out.println("CONVERSION -> lissage des valeurs interieur:"+moyenneinterieur+" exterieur:"+moyenneexterieur+" humidite:"+moyennehumidite);
            sommeinterieur = 0;
            sommeexterieur = 0;
            sommehumidite = 0;
           
        }else{
            
        }
         float[] statistiqueslisse = {moyenneinterieur,moyenneexterieur,moyennehumidite};
         
        
        
        float[] statistiquefloat = {interieur,exterieur,humidite};
            return statistiquefloat;
        
       // System.out.println("check des valeurs recupere dans conversion"+interieur+" "+exterieur+" "+humidite);
        //création de moyenne pour lisser les résultats
        
    }
    
    public static float getmoyenneinterieur(){
        return moyenneinterieur;
    }
    
    public static float getmoyenneexterieur(){
        return moyenneexterieur;
    }
    
    public static float getmoyennehumidite(){
        return moyennehumidite;
    }

}
