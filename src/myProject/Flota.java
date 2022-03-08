package myProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Flota extends JPanel{
    public static final String INFO = "• 1 portaaviones: ocupa 4 casillas"+"\n• 2 submarinos: ocupan 3 casillas cada uno"+"\n• 3 destructores: ocupan 2 casillas cada uno"+"\n• 4 fragatas: ocupan 1 casilla cada uno";
    public static final String PATH ="/recursos/";
    private JButton portaavion, destuctor, fragata, submarino;
    private JPanel panelFlota, textFlota;
    private JTextArea textoInfoBarcos;
    private ImageIcon imageDestructor, imagePortaavion, imageFragata, imageSubmarino;
    private TitledBorder tituloFlota,tituloInfo;
    private Border blackline;

    public Flota(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        barcos();
    }

    public void barcos(){
        GridBagConstraints gbc = new GridBagConstraints();

        // Flota
        blackline = BorderFactory.createLineBorder(Color.black);
        panelFlota = new JPanel();
        panelFlota.setPreferredSize(new Dimension(350,400));
        panelFlota.setBackground(new Color(178, 161, 255,152));
        tituloFlota = BorderFactory.createTitledBorder(blackline, "Tu barcos");
        tituloFlota.setTitleJustification(TitledBorder.CENTER);
        panelFlota.setBorder(tituloFlota);
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

        // Imagenes
        imageDestructor = new ImageIcon(getClass().getResource(PATH + "destructor.png"));
        imagePortaavion = new  ImageIcon(getClass().getResource(PATH+"portaavion.png"));
        imageFragata = new ImageIcon(getClass().getResource(PATH+"fragata.png"));
        imageSubmarino = new ImageIcon(getClass().getResource(PATH+"submarino.png"));
        // Botones
        portaavion = new JButton("",imagePortaavion);
        destuctor = new JButton("",imageDestructor);
        fragata = new JButton("",imageFragata);
        submarino = new JButton("",imageSubmarino);
    }

    public JButton getBotonPortaavion(){
        return portaavion;
    }
}
