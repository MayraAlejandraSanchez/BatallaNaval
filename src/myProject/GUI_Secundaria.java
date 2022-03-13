package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI_Secundaria extends JFrame {
    public static final String PATH = "/recursos/";
    private Header titulo;
    private JLabel enemy;
    private ImageIcon enemyIcon;
    private PanelTableroOponente panelTableroOponente;
    private PintarFlotaOponente pintarFlotaOponente;

    public GUI_Secundaria() {
        initGUI_Secundaria();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        Image image = new ImageIcon(getClass().getResource(PATH + "barcoIcono.png")).getImage();
        this.setIconImage(image);
        this.setUndecorated(false);
        this.setSize(600, 600);
        this.setResizable(true);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    private void initGUI_Secundaria() {
        // Set up JFrame Container's Layout
        getContentPane().setLayout(new BorderLayout(0,0));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.CYAN);
        getContentPane().add(panelPrincipal,BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0,0));

        JPanel panelSup = new JPanel();
        panelSup.setBackground(Color.CYAN);
        panelPrincipal.add(panelSup,BorderLayout.NORTH);
        panelSup.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.CYAN);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER,200,0));

        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.cyan);
        panelPrincipal.add(panelCentral,BorderLayout.CENTER);
        panelCentral.setLayout(new GridBagLayout());
        panelTableroOponente = new PanelTableroOponente();
        pintarFlotaOponente = new PintarFlotaOponente(panelTableroOponente);
        panelCentral.add(panelTableroOponente);

        // Set up JComponents
        // Titulo
        titulo = new Header("MOVIMIENTOS ENEMIGO", Color.CYAN);
        panelSup.add(titulo,FlowLayout.LEFT);

        // Icono
        enemyIcon = new ImageIcon(getClass().getResource(PATH+"enemy.png"));
        JLabel enemy = new JLabel(enemyIcon);
        panelSup.add(enemy,FlowLayout.CENTER);
    }


    public void distribucionFlotaOponente(){
        Random barcoAleatorio = new Random();
        String nombreBarco = "";
        int numBarcoAleatorio = barcoAleatorio.nextInt(4)+1;

        switch (numBarcoAleatorio){
            case 1: nombreBarco = "portavion";
                break;
            case 2: nombreBarco = "submarino";
                break;
            case 3: nombreBarco = "destructor";
                break;
            case 4: nombreBarco = "fragata";
                break;
        }

        Random orientacionAleatoria = new Random();
        int numOrientacionAleatoria = orientacionAleatoria.nextInt(2);

        Random sentidoAleatorio = new Random();
        int numSentidoAleatorio = 0;
        switch (numOrientacionAleatoria){
            case 0:
                numSentidoAleatorio = sentidoAleatorio.nextInt(2)+1;
                break;
            case 1:
                numSentidoAleatorio = sentidoAleatorio.nextInt(4-3)+3;
                break;
        }

        Random columnaAleatoria = new Random();
        int numColumnaAleatoria = columnaAleatoria.nextInt(10)+1;

        Random filaAleatoria = new Random();
        int numFilaAleatoria = filaAleatoria.nextInt(10)+1;

        if(numBarcoAleatorio == 1 &&  pintarFlotaOponente.getCantidadPortavion() > 0){
            if(!pintarFlotaOponente.funcionesFlota(nombreBarco,numOrientacionAleatoria, numSentidoAleatorio, numColumnaAleatoria, numFilaAleatoria)){
                distribucionFlotaOponente();
            }else{
                pintarFlotaOponente.setCantidadPortavion();
            }
        }else{
            if(numBarcoAleatorio == 2 &&  pintarFlotaOponente.getCantidadSubmarino() > 0){
                if(!pintarFlotaOponente.funcionesFlota(nombreBarco,numOrientacionAleatoria, numSentidoAleatorio, numColumnaAleatoria, numFilaAleatoria)){
                    distribucionFlotaOponente();
                }else{
                    pintarFlotaOponente.setCantidadSubmarino();
                }
            }else{
                if(numBarcoAleatorio == 3 &&  pintarFlotaOponente.getCantidadDestructor() > 0){
                    if(!pintarFlotaOponente.funcionesFlota(nombreBarco,numOrientacionAleatoria, numSentidoAleatorio, numColumnaAleatoria, numFilaAleatoria)){
                        distribucionFlotaOponente();
                    }else{
                        pintarFlotaOponente.setCantidadDestructor();
                    }
                }else{
                    if(numBarcoAleatorio == 4 &&  pintarFlotaOponente.getCantidadFragata() > 0){
                        if(!pintarFlotaOponente.funcionesFlota(nombreBarco,numOrientacionAleatoria, numSentidoAleatorio, numColumnaAleatoria, numFilaAleatoria)){
                            distribucionFlotaOponente();
                        }else{
                            pintarFlotaOponente.setCantidadFragata();
                        }
                    }
                }
            }
        }
    }

    // Retorna el panelTableroOponente
    public PanelTableroOponente getPanelTableroOponente(){
        return panelTableroOponente;
    }

    // Retorna el objeto para pintar la flota oponente
    public PintarFlotaOponente getPintarFlotaOponente(){
        return pintarFlotaOponente;
    }
}