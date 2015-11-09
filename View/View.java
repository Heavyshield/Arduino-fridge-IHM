package View;

import Controler.Acquisition;
import Controler.Conversion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class View {

    static int x = 0;
    static int y = 0;
    static int z = 0;
    static JFrame window = new JFrame();
    static XYSeries series = new XYSeries("Evolution de la température interieur");
    static XYSeries series2 = new XYSeries("Evolution de l humidite");
    //static XYSeries series3 = new XYSeries("Evolution de la température exterieur");
    static XYSeriesCollection dataset = new XYSeriesCollection(series);
     static XYSeriesCollection dataset2 = new XYSeriesCollection(series2);
     //static XYSeriesCollection dataset3 = new XYSeriesCollection(series3);

    //static float inter = Conversion.statistiqueslisse[1];

    public static void Displaygraph() {
		// create and configure the window
        //JFrame window = new JFrame();
        window.setTitle("Sensor Graph GUI");
        window.setSize(1200, 900);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		// create the line graph
        JFreeChart chart = ChartFactory.createXYLineChart("Température interieur", "Time (seconds)", "Température", View.dataset);
        //JFreeChart chart3 = ChartFactory.createXYLineChart("Humidité", "Time (seconds)", "Humidité %", View.dataset3);
       JFreeChart chart2 = ChartFactory.createXYLineChart("Humidité", "Time (seconds)", "Humidité %", View.dataset2);
        window.add(new ChartPanel(chart), BorderLayout.CENTER);
        window.add(new ChartPanel(chart2), BorderLayout.SOUTH);
       // window.add(new ChartPanel(chart3), BorderLayout.SOUTH);
        //window.add(new ChartPanel(chart), BorderLayout.SOUTH);
        // show the window
        window.setVisible(true);
    }

    public static void updateGraph() {
        // get and add value to the graph
        float number = Conversion.interieur;
        //System.out.println(number);
        series.add(x++, number);
        window.repaint();
    }
    public static void updateGraph2(){
        float humidite = Conversion.humidite;
        series2.add(y++, humidite);
        window.repaint();
    }
    /*
     public static void updateGraph3(){
        float humidite = Conversion.humidite;
        series3.add(z++, humidite);
        window.repaint();
    }
*/
    public static void refresh() {
        window.repaint();
    }
}
