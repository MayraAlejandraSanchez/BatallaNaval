package myProject;

import javax.swing.*;
import java.awt.*;

public class PintarTablero extends JPanel {
    private Tableros tableroPosicion, tableroPrincipal;
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private String abecedario[];

    public PintarTablero(){
        this.setLayout(new GridLayout(1,2, 10, 0));
        panelTableroPosicion = new JPanel(new GridLayout(11, 11));
        panelTableroPrincipal = new JPanel(new GridLayout(11, 11));
        tableroPosicion = new Tableros();
        tableroPrincipal = new Tableros();
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
                            tableroPosicion.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                            tableroPrincipal.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
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

        add(panelTableroPosicion);
        add(panelTableroPrincipal);
    }

    // Retorna la matriz posicion
    public JLabel[][] getMatrizPosicion(){
        return tableroPosicion.getMatriz();
    }

    // Retorna la matriz principal
    public JLabel[][] getMatrizPrincipal(){
        return tableroPrincipal.getMatriz();
    }
}
