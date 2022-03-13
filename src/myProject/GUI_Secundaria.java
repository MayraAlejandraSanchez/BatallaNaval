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

    public GUI_Secundaria() {
        initGUI_Secundaria();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        Image image = new ImageIcon(getClass().getResource(PATH + "barcoIcono.png")).getImage();
        this.setIconImage(image);
        this.setUndecorated(false);
        this.setSize(600, 600);
        this.setResizable(true);
        this.setVisible(true);
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

    public void distribucionFlotaOponente(String barco, int estadoOrientacion, int estadoSentidoOrientacion, int col, int row){
    }
}