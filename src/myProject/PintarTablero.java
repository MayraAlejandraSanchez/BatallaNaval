package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PintarTablero extends JPanel {
    private JLabel tableroPosicion[][], tableroPrincipal[][];
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private HashMap<Integer, String> coordenadas;
    private String abecedario[];

    public PintarTablero(){
        this.setLayout(new GridLayout(1,2, 10, 0));
        panelTableroPosicion = new JPanel(new GridLayout(11, 11));
        panelTableroPrincipal = new JPanel(new GridLayout(11, 11));
        tableroPosicion = new JLabel[11][11];
        tableroPrincipal = new JLabel[11][11];
        coordenadas = new HashMap<>();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        panelTableroPosicion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelTableroPosicion.setBackground(Color.BLACK);
        //panelTableroPosicion.setPreferredSize(new Dimension(200, 200));
        panelTableroPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelTableroPrincipal.setBackground(Color.BLACK);
        //panelTableroPrincipal.setPreferredSize(new Dimension(200, 200));

        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                if(row == 0 && col == 0){
                    tableroPosicion[row][col] = new JLabel("", SwingConstants.CENTER);
                    tableroPrincipal[row][col] = new JLabel("", SwingConstants.CENTER);
                }else{
                    if(row == 0 && col > 0){
                        tableroPosicion[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                        tableroPrincipal[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                    }else{
                        if(row > 0 && col == 0){
                            tableroPosicion[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                            tableroPrincipal[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                        }else{
                            tableroPosicion[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                            tableroPrincipal[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                        }
                    }
                }
                tableroPosicion[row][col].setOpaque(true);
                tableroPosicion[row][col].setBackground(Color.WHITE);
                tableroPosicion[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                tableroPrincipal[row][col].setOpaque(true);
                tableroPrincipal[row][col].setBackground(Color.WHITE);
                tableroPrincipal[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                panelTableroPosicion.add(tableroPosicion[row][col]);
                panelTableroPrincipal.add(tableroPrincipal[row][col]);
            }
        }

        add(panelTableroPosicion);
        add(panelTableroPrincipal);
    }

    // Retorna la matriz posicion
    public JLabel[][] getMatrizPosicion(){
        return tableroPosicion;
    }

    // Retorna la matriz principal
    public JLabel[][] getMatrizPrincipal(){
        return tableroPrincipal;
    }
}
