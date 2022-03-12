package myProject;

import javax.swing.*;
import java.util.HashMap;

public class Tableros {
    private JLabel tablero[][];
    private HashMap<Integer, String> casillasOcupadas;

    // Constructor
    public Tableros(){
        tablero = new JLabel[11][11];
        casillasOcupadas = new HashMap<>();
    }

    // Retorna la matriz
    public JLabel[][] getMatriz(){
        return tablero;
    }

    // Retorna las coordenadas
    public HashMap getCasillasOcupadas(){
        return casillasOcupadas;
    }
}