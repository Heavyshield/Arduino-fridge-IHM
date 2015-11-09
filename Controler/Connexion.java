/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

//import static Controler.Main.output;
import com.fazecast.jSerialComm.*;
import java.io.OutputStream;
import java.io.*;

/**
 *
 * @author Thibaud
 */
public class Connexion {
    
     static OutputStream output;
     static BufferedWriter outputcontent;
     static BufferedReader inputcontent;
     static SerialPort comPort;

    public static boolean connexion(){
        //comPort.closePort();
       
        
        //Obtention du port
        try {
            comPort = SerialPort.getCommPorts()[0];
        } catch (Exception e) {
            System.err.println("Erreur : port introuvable");
            return false;
        }
         
        
        //Si le port est indisponible
        if (comPort.openPort() == false) {
            System.err.println("Erreur : port déja utilisé");
            return false;
        }
        else {
            
            //Creation du flux
            //Flux de lecture de l'arduino
        InputStream input = comPort.getInputStream();
        
         //Flux d'ecriture de l'arduino
        OutputStream output = comPort.getOutputStream();
       
        //output = comPort.getOutputStream();
        
        //Enregistrement du flux
         inputcontent = new BufferedReader(new InputStreamReader(input));
         outputcontent = new BufferedWriter(new OutputStreamWriter(output));
        
        System.err.println("flux crée");
        
            return true;
        }

    }
    
        public static OutputStream getOutput()
        {
            return output;
        }
        
        public static BufferedWriter getoutputcontent()
        {
            return outputcontent;
        }
        
        public static BufferedReader getinputcontent()
        {
            return inputcontent;
        }
        
        public static SerialPort getcomPort()
        {
            return comPort;
        }
}
