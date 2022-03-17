package myProject;

import javax.swing.*;
import java.util.HashMap;

public class Tableros {
    private JLabel tablero[][];
    private HashMap<JLabel, Integer> casillasOcupadas; // Verifica si la casilla esta ocupada por una nave
    private HashMap<JLabel, Integer> casillaBarco; // Relacion entre la casilla y las casillas que usa la nave
    private HashMap<JLabel, String> casillaNombreBarco; // Nombre de la nave ubicada en una casilla

    // Constructor
    public Tableros(){
        tablero = new JLabel[11][11];
        casillasOcupadas = new HashMap<>();
        casillaBarco = new HashMap<>();
        casillaNombreBarco = new HashMap<>();
    }

    // Reduce la cantidad de casillas ocupadas por los barcos para que sea hundido
    public void reducirCasillasUsadas(String barco){
        for (int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                if(casillaNombreBarco.get(tablero[row][col]) != null){
                    if(casillaNombreBarco.get(tablero[row][col]).equals(barco)){
                        casillaBarco.replace(tablero[row][col], casillaBarco.get(tablero[row][col])-1);
                    }
                }
            }
        }
    }

    // Retorna la matriz
    public JLabel[][] getMatriz(){
        return tablero;
    }

    // Retorna el map casillasOcupadas
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