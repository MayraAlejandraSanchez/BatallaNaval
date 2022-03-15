package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelTableroOponente extends JPanel {
    private JPanel panelTableroPosicion;
    private JLabel nombreTableroPosicion;
    private Tableros tableroPosicionOponente;
    private String abecedario[];

    public PanelTableroOponente(){
        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        this.setBackground(Color.CYAN);
        tableroPosicionOponente = new Tableros();
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
                }else{
                    if(row == 0 && col > 0){
                        tableroPosicionOponente.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                    }else{
                        if(row > 0 && col == 0){
                            tableroPosicionOponente.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                        }else{
                            tableroPosicionOponente.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                        }
                    }
                }

                tableroPosicionOponente.getMatriz()[row][col].setOpaque(true);
                tableroPosicionOponente.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPosicionOponente.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                panelTableroPosicion.add(tableroPosicionOponente.getMatriz()[row][col]);
            }
        }
    }

    // Retorna la matriz posicion de la clase Tableros
    public JLabel[][] getMatrizPosicion(){
        return tableroPosicionOponente.getMatriz();
    }


    // Retorna el Map casillasOcupadas de la clase Tableros
    public HashMap getCasillasOcupadas(){
        return tableroPosicionOponente.getCasillasOcupadas();
    }

    // Retorna la lista casillaBarco de la clase Tableros
    public HashMap getCasillaBarco(){
        return tableroPosicionOponente.getCasillaBarco();
    }

    // Retorna el map casillaNombreBarco de la clase Tableros
    public HashMap getCasillaNombreBarco(){
        return tableroPosicionOponente.getCasillaNombreBarco();
    }

    public Tableros getTableroPosicionOponente(){
        return tableroPosicionOponente;
    }
}
