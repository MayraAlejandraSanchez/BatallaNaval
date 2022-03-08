package myProject;

import javax.swing.*;
import java.awt.*;

public class PintarTablero extends JPanel {
    private Tableros tableroPosicion, tableroPrincipal;
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private String abecedario[];

    public PintarTablero(){
        inicar();
    }

    public void inicar(){
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gb);

        // Panel tablero posicion
        panelTableroPosicion = new JPanel(new GridLayout(11, 11));
        panelTableroPosicion.setPreferredSize(new Dimension(400, 400));
        panelTableroPosicion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPosicion.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,30,0,30);
        this.add(panelTableroPosicion, gbc);

        // Panel tablero principal
        panelTableroPrincipal = new JPanel(new GridLayout(11, 11));
        panelTableroPrincipal.setPreferredSize(new Dimension(400, 400));
        panelTableroPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPrincipal.setBackground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,30,0,30);
        this.add(panelTableroPrincipal, gbc);

        tableroPosicion = new Tableros();
        tableroPrincipal = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

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
