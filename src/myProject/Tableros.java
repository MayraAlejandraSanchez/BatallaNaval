package myProject;

import javax.swing.*;
import java.util.HashMap;

public class Tableros {
    private JLabel tablero[][];
    private HashMap<JLabel, Integer> casillasOcupadas; // Verifica si la casilla esta ocupada por una nava
    private HashMap<JLabel, Integer> casillaBarco; // Cantidad de casillas usadas por barco
    private HashMap<JLabel, String> casillaNombreBarco; // Nombre de la nave ubicada en una casilla

    // Constructor
    public Tableros(){
        tablero = new JLabel[11][11];
        casillasOcupadas = new HashMap<>();
        casillaBarco = new HashMap<>();
        casillaNombreBarco = new HashMap<>();
    }

    // Retorna la matriz
    public JLabel[][] getMatriz(){
        return tablero;
    }

    // Retorna el map csaillasOcupadas
    public HashMap getCasillasOcupadas(){
        return casillasOcupadas;
    }

    // Retorna el map casillaBarco
    public HashMap getCasillaBarco(){
        return casillaBarco;
    }

    // Retorna el map casillaNombreBarco
    public HashMap getCasillaNombreBarco(){
        return casillaNombreBarco;
    }
}