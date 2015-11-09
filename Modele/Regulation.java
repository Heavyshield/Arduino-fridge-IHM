/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controler.Insertion;
import static java.lang.Math.pow;
import sun.applet.Main;

/**
 *
 * @author Thibaud
 */
//refonte de la classe....
/*
 public class Regulation {
 public static boolean Rosee(float temperature, float humidite)
 {
 float rosee = (float) (pow((double)humidite, 0.125)*(112+(0.9 * temperature)) + (0.1 * temperature) - 112);
        
 if(temperature <= rosee)
 {
 Insertion i = Controler.Main.getinsertion();
 lancerThreadInsertion(i,"1");
 return false;
 }
 else
 {
           
 Insertion i = Controler.Main.getinsertion();
 lancerThreadInsertion(i,"1");
             
 return true;
 }
 }
    
 }
 */
public class Regulation {
    
  //private static int compteur;

    //la méthode régulation vas appeler les différantes méthodes et leurs passer les statistiques si l'une d'elle est valider il y aura en return true
    public static boolean regulation(float[] statistiques, int consigne) {
        
        /*
        if(statistiques.equals(null)){
           
            return null;
        }
        */
        
        float interieur = statistiques[0];
        float exterieur = statistiques[1];
        float humidite = statistiques[2];
        
        //Chaque sous méthodes retourne un booléean 
        //si le point de reseau est atteint et que le seuille est dépassé allume
        if(pointrosee(interieur, humidite)&&(seuille(interieur, consigne))){
            //compteur++;
            return true;
        }
        
        //rajouter des elseif avec les autres fonctions 
        else{
            return false;
        }
        

    }

    //si le point de rosée est atteint (temperature trop grande
    public static boolean pointrosee(float temperature, float humidite) {
        float rosee = (float) (pow((double) humidite, 0.125) * (112 + (0.9 * temperature)) + (0.1 * temperature) - 112);

        //temperature trop basse, exctinction du frigo
        if (temperature <= rosee)  {
         
            return false;
        } else {

        
            return true;
        }

        

    }
    
    //Si la temperature dépasse le seuille en moins ou en plus -> true
    public static boolean seuille(float temperature, int consigne) {
         if(temperature > (consigne +1)||temperature < (consigne -1))
        {
            return true;
        }
        
       
        return false;
    }
    
}
