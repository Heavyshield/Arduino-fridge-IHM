package Controler;


import static Controler.Connexion.connexion;
import static Controler.Connexion.getinputcontent;
import static Controler.Connexion.getoutputcontent;


import View.View;

import com.fazecast.jSerialComm.*;
import java.io.OutputStream;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    static OutputStream output;
    static Insertion insertion;
    static BufferedReader acquisition;
    static SerialPort comPort;

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        if (connexion()) {
            System.out.println("connexion réussi");
            acquisition = getinputcontent();
            insertion = new Insertion(getoutputcontent());
            System.out.println("Lancement trhead acquisition");
            lancerThreadAcquisition(acquisition, comPort, insertion);
            View.Displaygraph();
            lancerThreadGraph();

        } else if (!(connexion())) {
            System.out.println("Connexion échoué lancement de la simulation");
            lancerThreadSimulation();
            View.Displaygraph();
            lancerThreadGraph();
            //lancerThreadGraph();

        }

    }

    //ThreadAcquisition----------------------------------------------------------------------------------------------
    private static void lancerThreadAcquisition(BufferedReader inputcontent, SerialPort comPort, Insertion insertion) {
        new Thread(new Runnable() {
            int compteur = 0;
            int consigne = 18;

            @Override
            public void run() {
                System.out.println("Acquisition démarrée");

                while (true) {
                    try {

                        //L'acquisition remonte les valeurs de l'arduino qui seront convertis puis analysés
                        //Si la regulation return 1 le frigo s'allume
                        if (Modele.Regulation.regulation(Controler.Conversion.conversion(Controler.Acquisition.acquisition(acquisition, comPort), compteur), consigne) == true) {

                            insertion.write("1");

                            //System.out.println("Le frigo s'allume");
                            //Si la regulation return 0 le frigo s'eteint     
                        } else if (Modele.Regulation.regulation(Controler.Conversion.conversion(Controler.Acquisition.acquisition(acquisition, comPort), compteur), consigne) == false) {

                           //Controler.Insertion.write("0");
                            insertion.write("0");
                            //System.out.println("Le frigo s'éteint");
                            //Si la regulation return 2 rien ne change    
                        } else {
                            //Rien ne change
                            System.out.println("Rien ne change");
                        }

                        
                         if (compteur > 14) {
                         compteur = 0;
                         } else {
                         compteur++;
                         }
                         
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        System.err.println("Erreur: lecture impossible " + ex);
                    }
                }
            }
        }).start();
    }

    //ThreadSimulation---------------------------------------------------------------------------
    private static void lancerThreadSimulation() {

        new Thread(new Runnable() {
            int compteur = 0;
            int consigne = 18;

            @Override
            public void run() {
                System.out.println("Simulation démarrée");

                while (true) {
                    try {

                        //la simulation génere une valeur, qui est convertie, puis régulé.
                        //Si la regulation return true le frigo s'allume
                        if (Modele.Regulation.regulation(Controler.Conversion.conversion(Modele.Simulation.simulation(), compteur), consigne) == true) {

                            insertion.write("1");
                            System.out.println("Le frigo s'allume");
                            //Si la regulation return false le frigo s'eteint     
                        } else if (Modele.Regulation.regulation(Controler.Conversion.conversion(Modele.Simulation.simulation(), compteur), consigne) == false) {

                            insertion.write("0");
                            System.out.println("Le frigo s'éteint");
                            //Si la regulation return null rien ne change    
                        } else {
                            //Rien ne change
                            System.out.println("Rien ne change");
                        }
                        if (compteur > 14) {
                            compteur = 0;
                        } else {
                            compteur++;
                        }

                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.err.println("Erreur: Simulation impossible" + e);
                    }
                }
            }
        }).start();
    }

     //ThreadGraph
    private static void lancerThreadGraph() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int z = 0;
                while (true) {
                    try {
			View.Displaygraph();
                	View.refresh();
                        View.updateGraph();
                        View.updateGraph2();
                       // View.updateGraph3();
                        
                        Thread.sleep(420);
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }).start();
    }
}
