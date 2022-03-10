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
        portavion = new JButton();
        portavion.setText("PORTAVION");
        portavion.setIcon(imagePortavion);
        portavion.setBackground(Color.CYAN);
        portavion.setHorizontalTextPosition( SwingConstants.CENTER );
        portavion.setVerticalTextPosition( SwingConstants.BOTTOM );
        portavion.setFocusable(false);
        portavion.setBorder(null);

        destuctor = new JButton();
        destuctor.setText("DESTRUCTOR");
        destuctor.setIcon(imageDestructor);
        destuctor.setBackground(Color.CYAN);
        destuctor.setHorizontalTextPosition( SwingConstants.CENTER );
        destuctor.setVerticalTextPosition( SwingConstants.BOTTOM );
        destuctor.setFocusable(false);
        destuctor.setBorder(null);

        fragata = new JButton();
        fragata.setText("FRAGATA");
        fragata.setIcon(imageFragata);
        fragata.setBackground(Color.CYAN);
        fragata.setHorizontalTextPosition( SwingConstants.CENTER );
        fragata.setVerticalTextPosition( SwingConstants.BOTTOM );
        fragata.setFocusable(false);
        fragata.setBorder(null);

        submarino = new JButton();
        submarino.setText("SUBMARINO");
        submarino.setIcon(imageSubmarino);
        submarino.setBackground(Color.CYAN);
        submarino.setHorizontalTextPosition( SwingConstants.CENTER );
        submarino.setVerticalTextPosition( SwingConstants.BOTTOM );
        submarino.setFocusable(false);
        submarino.setBorder(null);

        vertical = new JButton("Vertical");
        horizontal = new JButton("Horizontal");

        // Flota
        blackline = BorderFactory.createLineBorder(Color.black);
        panelFlota = new JPanel();
        panelFlota.setLayout(new GridLayout(2,2,10,10));
        panelFlota.setPreferredSize(new Dimension(350,400));
        panelFlota.setBackground(Color.CYAN);
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