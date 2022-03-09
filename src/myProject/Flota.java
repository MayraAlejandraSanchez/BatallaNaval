package myProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Flota extends JPanel{
    public static final String INFO = "• 1 portaaviones: ocupa 4 casillas"+"\n• 2 submarinos: ocupan 3 casillas cada uno"+"\n• 3 destructores: ocupan 2 casillas cada uno"+"\n• 4 fragatas: ocupan 1 casilla cada uno";
    public static final String PATH ="/recursos/";
    private JButton portavion, destuctor, fragata, submarino, vertical, horizontal;
    private JPanel panelFlota, textFlota;
    private JTextArea textoInfoBarcos;
    private ImageIcon imageDestructor, imagePortavion, imageFragata, imageSubmarino;
    private TitledBorder tituloFlota,tituloInfo;
    private Border blackline;

    public Flota(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        barcos();
    }

    public void barcos(){
        GridBagConstraints gbc = new GridBagConstraints();

        // Imagenes
        imageDestructor = new ImageIcon(getClass().getResource(PATH + "destructor.png"));
        imagePortavion = new  ImageIcon(getClass().getResource(PATH+"portavion.png"));
        imageFragata = new ImageIcon(getClass().getResource(PATH+"fragata.png"));
        imageSubmarino = new ImageIcon(getClass().getResource(PATH+"submarino.png"));

        // Botones
        portavion = new JButton("",imagePortavion);
        portavion.setFocusable(false);
        portavion.setBorder(null);

        destuctor = new JButton("",imageDestructor);
        destuctor.setFocusable(false);
        destuctor.setBorder(null);

        fragata = new JButton("",imageFragata);
        fragata.setFocusable(false);
        fragata.setBorder(null);

        submarino = new JButton("",imageSubmarino);
        submarino.setFocusable(false);
        submarino.setBorder(null);

        vertical = new JButton("Vertical");
        horizontal = new JButton("Horizontal");

        // Flota
        blackline = BorderFactory.createLineBorder(Color.black);
        panelFlota = new JPanel();
        panelFlota.setLayout(new GridLayout(2,2));
        panelFlota.setPreferredSize(new Dimension(350,400));
        panelFlota.setBackground(new Color(178, 161, 255,152));
        tituloFlota = BorderFactory.createTitledBorder(blackline, "Tus barcos");
        tituloFlota.setTitleJustification(TitledBorder.CENTER);
        panelFlota.setBorder(tituloFlota);
        panelFlota.add(portavion);
        panelFlota.add(destuctor);
        panelFlota.add(fragata);
        panelFlota.add(submarino);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(panelFlota, gbc);

        // Texto bajo flota
        textFlota = new JPanel();
        textoInfoBarcos = new JTextArea();
        textoInfoBarcos= new JTextArea(4,5);
        textoInfoBarcos.setText(INFO);
        textoInfoBarcos.setEditable(false);
        textFlota.setPreferredSize(new Dimension(350,100));
        textFlota.setBackground(Color.white);
        tituloInfo = BorderFactory.createTitledBorder(blackline, "Información de barcos");
        tituloInfo.setTitleJustification(TitledBorder.CENTER);
        textFlota.setBorder(tituloInfo);
        textFlota.add(textoInfoBarcos);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(textFlota, gbc);
    }

    public JButton getBotonPortavion(){
        return portavion;
    }

    public JButton getBotonDestructor(){
        return destuctor;
    }

    public JButton getBotonFragata(){
        return fragata;
    }

    public JButton getBotonSubmarino(){
        return submarino;
    }

    public JButton getBotonVertical(){
        return vertical;
    }

    public JButton getBotonHorizontal(){
        return horizontal;
    }
}