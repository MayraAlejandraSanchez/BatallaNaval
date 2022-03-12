package myProject;

import javax.swing.*;
import java.awt.*;

public class ModelTableroOponente {
    private Tableros tableroPosicionOponente;
    private String abecedario[];
    private PanelTableroOponente panelTableroOponente;

    public ModelTableroOponente(PanelTableroOponente _panelTableroOponente){
        this.panelTableroOponente = _panelTableroOponente;
        tableroPosicionOponente = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        modelTableroOponente();
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

                panelTableroOponente.getPanelTableroPosicion().add(tableroPosicionOponente.getMatriz()[row][col]);
            }
        }
    }
}
