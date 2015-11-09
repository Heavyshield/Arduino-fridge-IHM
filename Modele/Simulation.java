/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Random;

/**
 *
 * @author Thibaud
 */
//Simule le fonctionement du frigo en générant des relevés aléatoires
public class Simulation {

    static private Random random;

    static public int tempext = 2300;
    static public int tempint = 1800;
    static public int humd = 3000;

    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    //genere des relevés aléatoire sur la console
    public static int[] simulation() {
        //int[] statistiques;

        //random = new Random();
        if (getRandomBoolean() && tempint < 2500) {
            tempint += 10;
        } else if (!(getRandomBoolean()) && tempint > 1000) {
            tempint -= 10;
        }else{
            tempint = 1800;
        }

        if (getRandomBoolean() && tempext < 4000) {
            tempext += 10;
        } else if (!(getRandomBoolean()) && tempext > 0) {
            tempint -= 10;
        }else{
            tempext = 2300;
        }

        if (getRandomBoolean() && humd < 10000) {
            humd += 10;
        } else if (!(getRandomBoolean()) && humd > 0) {
            humd -= 10;
        }else{
            humd = 3000;
        }
 /*       
        Random a = new Random();
        Random b = new Random();
        Random c = new Random();
        int Lowtemp = 13;
        int Hightemp = 25;
        int Lowhumd = 30;
        int Highumd = 50;

        int tempext = (a.nextInt(Hightemp - Lowtemp) + Lowtemp) * 100;
        int tempint = (b.nextInt(Hightemp - Lowtemp) + Lowtemp) * 100;
        int humd = (c.nextInt(Highumd - Lowhumd) + Lowhumd) * 100;
*/
        //System.out.println("CONSOLE-------");
        System.out.println("SIMULATION");
        System.out.println(tempext + "#" + tempint + "#" + humd);

        int[] statistiques = {tempint, humd, tempext};
        return statistiques;
    }

}
