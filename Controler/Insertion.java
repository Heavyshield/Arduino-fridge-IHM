/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JSlider;
import com.fazecast.jSerialComm.*;
import java.io.OutputStream;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

/**
 *
 * @author Thibaud
 */
public class Insertion {
    
    private final BufferedWriter stream;

    public Insertion(BufferedWriter outputcontent) {
        this.stream = outputcontent;
    }

    public void write(String msg) throws IOException {
        
        //System.out.println("message envoye: "+msg);
       
        this.stream.write(msg);
        this.stream.flush();
    }
    
}

