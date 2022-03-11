package myProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelFlota extends JPanel{
    public static final String INFO = "• 1 portaaviones: ocupa 4 casillas"+"\n• 2 submarinos: ocupan 3 casillas cada uno"+"\n• 3 destructores: ocupan 2 casillas cada uno"+"\n• 4 fragatas: ocupan 1 casilla cada uno";
    public static final String PATH ="/recursos/";
    private JButton portavion, destuctor, fragata, submarino, vertical, horizontal,sup_inf,inf_sup,izq_der,der_izq,explicacionBotones;
    private JPanel panelFlota, textFlota, panelBotones, subpanelBotones, subpanelBotones2;
    private JTextArea textoInfoBarcos;
    private ImageIcon imageDestructor, imagePortavion, imageFragata, imageSubmarino;
    private TitledBorder tituloFlota,tituloInfo, titulo_Orientacion;
    private Border blackline;
    private String nombreBoton; // Guarda el texto del boton
    private int orientacion; // 0 si es vertical, 1 si es horizontal
    private int sentidoOrientacion; // 1 superior-inferior, 2 inferior-superior, 3 izquierda-derecha, 4 derecha-izquierda
    private int cantidadPortavion;
    private int cantidadSubmarino;
    private int cantidadDestructor;
    private int cantidadFragata;

    public PanelFlota(){
        GridBagLayout gbl = new GridBagLayout();
        this.setLayout(gbl);
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(600,100));
        barcos();
    }

    public void barcos(){
        GridBagConstraints gbc = new GridBagConstraints();

        nombreBoton = "";
        orientacion = 0;
        sentidoOrientacion = 0;

        // Cantidad inicial de barcos
        cantidadPortavion = 1;
        cantidadSubmarino = 2;
        cantidadDestructor = 3;
        cantidadFragata = 4;

        // Imagenes
        imageDestructor = new ImageIcon(getClass().getResource(PATH + "destructor.png"));
        imagePortavion = new  ImageIcon(getClass().getResource(PATH+"portavion.png"));
        imageFragata = new ImageIcon(getClass().getResource(PATH+"fragata.png"));
        imageSubmarino = new ImageIcon(getClass().getResource(PATH+"submarino.png"));

        // Botones de aviones
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

        // Botones de orientación
        vertical = new JButton("Vertical");
        vertical.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        vertical.setBackground(Color.YELLOW);
        vertical.setFocusable(false);
        vertical.setBorder(null);

        horizontal = new JButton("Horizontal");
        horizontal.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        horizontal.setBackground(Color.green);
        horizontal.setFocusable(false);
        horizontal.setBorder(null);

        sup_inf = new JButton("Superior-Inferior");
        sup_inf.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        sup_inf.setBackground(Color.orange);
        sup_inf.setFocusable(false);
        sup_inf.setBorder(null);

        inf_sup = new JButton("Inferior-Superior");
        inf_sup.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        inf_sup.setBackground(Color.pink);
        inf_sup.setFocusable(false);
        inf_sup.setBorder(null);

        izq_der = new JButton("Izquierda-Derecha");
        izq_der.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        izq_der.setBackground(Color.white);
        izq_der.setFocusable(false);
        izq_der.setBorder(null);

        der_izq = new JButton("Derecha-Izquierda");
        der_izq.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        der_izq.setBackground(Color.magenta);
        der_izq.setFocusable(false);
        der_izq.setBorder(null);

        // Botón explicación de los botones de orientación
        explicacionBotones = new JButton("¿Cómo usar los botones de orientación?");
        explicacionBotones.setFont(new Font(Font.SERIF,Font.ROMAN_BASELINE,15));
        explicacionBotones.setBackground(Color.red);
        explicacionBotones.setFocusable(false);
        explicacionBotones.setBorder(null);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(explicacionBotones, gbc);


        // Flota
        blackline = BorderFactory.createLineBorder(Color.black);
        panelFlota = new JPanel();
        panelFlota.setLayout(new GridLayout(2,2,10,10));
        panelFlota.setPreferredSize(new Dimension(350,300));
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
        textoInfoBarcos.setBackground(Color.CYAN);
        textFlota.setPreferredSize(new Dimension(350,100));
        textFlota.setBackground(Color.cyan);
        tituloInfo = BorderFactory.createTitledBorder(blackline, "Información de barcos");
        tituloInfo.setTitleJustification(TitledBorder.CENTER);
        textFlota.setBorder(tituloInfo);
        textFlota.add(textoInfoBarcos);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(textFlota, gbc);

        // Panel botones dentro de panel flota
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0,2,5,10));
        panelBotones.setBackground(Color.CYAN);
        panelBotones.setPreferredSize(new Dimension(350,120));
        titulo_Orientacion = BorderFactory.createTitledBorder(blackline, "¿Como quieres acomodar tu flota?");
        titulo_Orientacion.setTitleJustification(TitledBorder.CENTER);
        panelBotones.setBorder(titulo_Orientacion);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(panelBotones,gbc);

        // panel dentro de panel botones para los botones de horizontal y vertical
        subpanelBotones = new JPanel(new GridLayout());
        subpanelBotones.setPreferredSize(new Dimension(175,120));
        subpanelBotones.setBackground(Color.cyan);
        subpanelBotones.setLayout(new GridLayout(2,0,5,5));
        subpanelBotones.add(vertical);
        subpanelBotones.add(horizontal);
        panelBotones.add(subpanelBotones,BorderLayout.WEST);

        // panel dentro de panel botones para los botones de sup_inf, inf_sup, der_izq, izq_der
        subpanelBotones2 = new JPanel();
        subpanelBotones2.setPreferredSize(new Dimension(175,120));
        subpanelBotones2.setBackground(Color.cyan);
        subpanelBotones2.setLayout(new GridLayout(4,0,5,5));
        subpanelBotones2.add(sup_inf);
        subpanelBotones2.add(inf_sup);
        subpanelBotones2.add(izq_der);
        subpanelBotones2.add(der_izq);
        panelBotones.add(subpanelBotones2,BorderLayout.EAST);

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

    public JButton getBotonSup_inf(){
        return sup_inf;
    }
    public JButton getBotonInf_sup(){
        return inf_sup;
    }

    public JButton getBotonIzq_der(){
        return izq_der;
    }

    public JButton getBotonDer_izq(){
        return der_izq;
    }

    public void setNombreBoton(String _nombreBoton){
        nombreBoton = _nombreBoton;
    }

    public String getNombreBoton(){
        return nombreBoton;
    }

    // Asigna el estado de orientacion
    public void setOrientacion(int _orientacion){
        orientacion = _orientacion;
    }

    // Asigna el estado de sentidoOrientacion
    public void setSentidoOrientacion(int _sentidoOrientacion){
        sentidoOrientacion = _sentidoOrientacion;
    }

    // Retorna el estado de orientacion
    public int getOrientacion(){
        return orientacion;
    }

    // Retorna el estado de sentidoOrientacion
    public int getSentidoOrientacion(){
        return sentidoOrientacion;
    }

    // Reduce la cantidad de portaviones disponibles
    public void setCantidadPortavion(){
        cantidadPortavion--;
    }

    // Reduce la cantidad de submarinos disponibles
    public void setCantidadSubmarino(){
        cantidadSubmarino--;
    }

    // Reduce la cantidad de destructores disponibles
    public void setCantidadDestructor(){
        cantidadDestructor--;
    }

    // Reduce la cantidad de fragatas disponibles
    public void setCantidadFragata(){
        cantidadFragata--;
    }

    // Retorna la cantidad de portaviones disponibles
    public int getCantidadPortavion(){
        return cantidadPortavion;
    }

    // Retorna la cantidad de submarinos disponibles
    public int getCantidadSubmarino(){
        return cantidadSubmarino;
    }

    // Retorna la cantidad de destructores disponibles
    public int getCantidadDestructor(){
        return cantidadDestructor;
    }

    // Retorna la cantidad de fragatas disponibles
    public int getCantidadFragata(){
        return cantidadFragata;
    }
}