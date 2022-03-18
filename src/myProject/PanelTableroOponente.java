package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
/**
 * Clase PanelTableroOponente
 * @autor Mayra Alejandra Sanchez - mayra.alejandra.sanchez@correounivalle.edu.co - 202040506
 * @autor Brayan Stiven Sanchez - brayan.sanchez.leon@correounivalle.edu.co - 202043554
 * @version 1.0.0 fecha 17/3/2022
 */
public class PanelTableroOponente extends JPanel {
    private JPanel panelTableroPosicion;
    private JLabel nombreTableroPosicion;
    private Tableros tableroPosicionOponente, tableroPrincipalOponente;
    private String abecedario[];

    public PanelTableroOponente(){
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        this.setBackground(Color.CYAN);
        tableroPosicionOponente = new Tableros();
        tableroPrincipalOponente = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        iniciar();
        modelTableroOponente();
    }

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
    }

    public void modelTableroOponente(){
        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                if(row == 0 && col == 0){
                    tableroPosicionOponente.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                    tableroPrincipalOponente.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                }else{
                    if(row == 0 && col > 0){
                        tableroPosicionOponente.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                        tableroPrincipalOponente.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                    }else{
                        if(row > 0 && col == 0){
                            tableroPosicionOponente.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                            tableroPrincipalOponente.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                        }else{
                            tableroPosicionOponente.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/mar.jpg")), SwingConstants.CENTER);
                            tableroPrincipalOponente.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/mar.jpg")), SwingConstants.CENTER);
                        }
                    }
                }

                tableroPosicionOponente.getMatriz()[row][col].setOpaque(true);
                tableroPosicionOponente.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPosicionOponente.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                tableroPrincipalOponente.getMatriz()[row][col].setOpaque(true);
                tableroPrincipalOponente.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPrincipalOponente.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                panelTableroPosicion.add(tableroPosicionOponente.getMatriz()[row][col]);
            }
        }
    }

    // Retorna el tablero ingresado
    public Tableros getTableroOponente(String _tablero){
        Tableros tablero = new Tableros();
        if(_tablero.equals("posicion")){
            tablero = tableroPosicionOponente;
        }else{
            if(_tablero.equals("principal")){
                tablero = tableroPrincipalOponente;
            }
        }
        return tablero;
    }
}
