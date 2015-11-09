package Controler;


import com.fazecast.jSerialComm.*;
import java.io.*;

//package Controler;
/**
 *
 * @author Thibaud
 */
//S'occupe de récuperer les informations de l'arduino et de les affichers basiquement en console
public class Acquisition {

    private static int interieur;
    private static int exterieur;
    private static int humidite;


    @SuppressWarnings("empty-statement")
    public static int[] acquisition(BufferedReader inputcontent, SerialPort comPort) throws IOException {

        try {

            //Passage du flux en string
            String data = inputcontent.readLine();
            //System.out.println("data brut "+data);

            //Si il n'y a pas de # il s'agit du moniteur, affichage
            if (!data.contains("#")) {

                System.out.println("CONSOLE ARDUINO");
                System.out.println(data);

            } else {
                
                System.out.println("ACQUISITION");
                System.out.println(data);
                //System.out.println("la data reçu:" + data);
                //Split de la ligne
                String[] value_split = data.split("#");

                //Répartition du split
                interieur = Integer.parseInt(value_split[0]);
                humidite = Integer.parseInt(value_split[1]);
                exterieur = Integer.parseInt(value_split[2]);
                
                
            }

        } catch (IndexOutOfBoundsException | IOException | NumberFormatException e) {
            System.out.println("Acquisition ERREUR:"+e);
            //Connexion.connexion();
            //comPort = Connexion.getcomPort();
            //inputcontent = Connexion.getinputcontent();
            
           // acquisition(inputcontent, comPort);

        }

        //System.out.println("ACQUISITION");
        int[] statistiques = {interieur, humidite, exterieur};

        //System.out.println("" +statistiques[0]+" "+statistiques[2]+" "+statistiques[1]+" ");
        return statistiques;

    }

}
