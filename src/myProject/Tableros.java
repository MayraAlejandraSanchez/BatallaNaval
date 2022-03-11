package myProject;

import javax.swing.*;
import java.util.HashMap;

public class Tableros {
    private JLabel tablero[][];
    private HashMap<Integer, String> coordenadas;

    // Constructor
    public Tableros(){
        tablero = new JLabel[11][11];
        coordenadas = new HashMap<>();
    }

    // Retorna la matriz
    public JLabel[][] getMatriz(){
        return tablero;
    }

    // Retorna las coordenadas
    public HashMap getCoordenadas(){
        return coordenadas;
    }
}