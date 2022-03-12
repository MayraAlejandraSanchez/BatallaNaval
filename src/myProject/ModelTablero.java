package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ModelTablero {
    private Tableros tableroPosicion, tableroPrincipal;
    private String abecedario[];
    private PanelTablero panelTablero;

    public ModelTablero(PanelTablero _panelTablero){
        this.panelTablero = _panelTablero;
        tableroPosicion = new Tableros();
        tableroPrincipal = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        modelTablero();
    }

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


                panelTablero.getPanelTableroPosicion().add(tableroPosicion.getMatriz()[row][col]);
                panelTablero.getPanelTableroPrincipal().add(tableroPrincipal.getMatriz()[row][col]);
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

    // Retorna el Map casillasOcupadas
    public HashMap getCasillasOcupadas(){
        return tableroPosicion.getCasillasOcupadas();
    }
}
