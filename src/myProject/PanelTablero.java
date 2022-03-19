package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Clase PanelTablero
 * @autor Mayra Alejandra Sanchez - mayra.alejandra.sanchez@correounivalle.edu.co - 202040506
 * @autor Brayan Stiven Sanchez - brayan.sanchez.leon@correounivalle.edu.co - 202043554
 * @version 1.0.0 fecha 17/3/2022
 */
public class PanelTablero extends JPanel {

    public static final String PATH ="/recursos/";
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private JLabel nombreTableroPosicion, nombreTableroPrincipal, imagenTiros;
    private Tableros tableroPosicion, tableroPrincipal;
    private String abecedario[];

    // Constructor
    public PanelTablero(){
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        this.setBackground(Color.CYAN);
        tableroPosicion = new Tableros();
        tableroPrincipal = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        iniciar();
        modelTablero();
    }

    // Establece la configuracion inicial del JComponent
    public void iniciar(){
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel tablero posicion
        nombreTableroPosicion = new JLabel("T A B L E R O   P O S I C I O N");
        nombreTableroPosicion.setForeground(new Color(0, 0, 0, 230));
        nombreTableroPosicion.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(nombreTableroPosicion, gbc);

        panelTableroPosicion = new JPanel(new GridLayout(11, 11));
        panelTableroPosicion.setPreferredSize(new Dimension(400, 400));
        panelTableroPosicion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPosicion.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,15,0,15);
        this.add(panelTableroPosicion, gbc);

        // Panel tablero principal
        nombreTableroPrincipal = new JLabel("T A B L E R O   P R I N C I P A L");
        nombreTableroPrincipal.setForeground(new Color(0, 0, 0, 230));
        nombreTableroPrincipal.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(nombreTableroPrincipal, gbc);

        panelTableroPrincipal = new JPanel(new GridLayout(11, 11));
        panelTableroPrincipal.setPreferredSize(new Dimension(400, 400));
        panelTableroPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPrincipal.setBackground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,15,0,15);
        this.add(panelTableroPrincipal, gbc);

        imagenTiros = new JLabel();
        imagenTiros.setIcon(new ImageIcon(getClass().getResource(PATH + "tiros.png")));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(imagenTiros, gbc);
    }

    // Crea los tableros posicion y principal
    public void modelTablero(){
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                if(row == 0 && col == 0){
                    tableroPosicion.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                    tableroPrincipal.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                }else{
                    if(row == 0 && col > 0){
                        tableroPosicion.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                        tableroPrincipal.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                    }else{
                        if(row > 0 && col == 0){
                            tableroPosicion.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                            tableroPrincipal.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                        }else{
                            tableroPosicion.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/mar.jpg")), SwingConstants.CENTER);
                            tableroPrincipal.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/mar.jpg")), SwingConstants.CENTER);
                        }
                    }
                }
                tableroPosicion.getMatriz()[row][col].setOpaque(true);
                tableroPosicion.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPosicion.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                tableroPrincipal.getMatriz()[row][col].setOpaque(true);
                tableroPrincipal.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPrincipal.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));


                panelTableroPosicion.add(tableroPosicion.getMatriz()[row][col]);
                panelTableroPrincipal.add(tableroPrincipal.getMatriz()[row][col]);
            }
        }
    }

    // Retorna el tablero ingresado
    public Tableros getTablero(String _tablero){
        Tableros tablero = new Tableros();
        if(_tablero.equals("posicion")){
            tablero = tableroPosicion;
        }else{
            if(_tablero.equals("principal")){
                tablero = tableroPrincipal;
            }
        }
        return tablero;
    }
}