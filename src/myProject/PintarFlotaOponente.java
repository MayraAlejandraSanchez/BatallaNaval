package myProject;

import javax.swing.*;
import java.util.ArrayList;

public class PintarFlotaOponente {
    private PanelTableroOponente panelTableroOponente;
    private int cantidadPortavion; // Cantidad total de portaviones
    private int cantidadSubmarino; // Cantidad total de submarinos
    private int cantidadDestructor; // Cantidad total de destructores
    private int cantidadFragata; // Cantidad total de fragatas
    private int barcoUsado; // Acumulador para identificar cual nave ha sido desplegada (en orden del 1 al 10)
    private ArrayList<Integer> casillasUsadasBarco; // casillas usadas por cada nave

    // Constructor
    public PintarFlotaOponente(PanelTableroOponente _panelTableroOponente){
        this.panelTableroOponente = _panelTableroOponente;
        cantidadPortavion = 1;
        cantidadSubmarino = 2;
        cantidadDestructor = 3;
        cantidadFragata = 4;
        barcoUsado = 1;
        casillasUsadasBarco = new ArrayList<>();
    }

    // Retorna la direccion de la imagen dependiendo del barco ingresado
    public String pathImages(String barco, int estadoOrientacion, int estadoSentidoOrientacion){
        String path = "";
        if(estadoOrientacion == 0){
            switch(estadoSentidoOrientacion){
                case 1:
                    path = "/recursos/" + barco + "_V_S_I/";
                    break;
                case 2:
                    path = "/recursos/" + barco + "_V_I_S/";
                    break;
            }
        }else{
            switch(estadoSentidoOrientacion){
                case 3:
                    path = "/recursos/" + barco + "_H_I_D/";
                    break;
                case 4:
                    path = "/recursos/" + barco + "_H_D_I/";
                    break;
            }
        }

        return path;
    }

    // Relaciona la casilla y la cantidad de casillas que usa el barco ingresado
    public void relacionJLabelBarco(JLabel casilla, String barco, int numeroBarco){
        if(barco.equals("portavion" + String.valueOf(numeroBarco))){
            casillasUsadasBarco.add(4);
            panelTableroOponente.getTableroPosicionOponente().getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
        }else{
            if(barco.equals("submarino" + String.valueOf(numeroBarco))){
                casillasUsadasBarco.add(3);
                panelTableroOponente.getTableroPosicionOponente().getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
            }else{
                if(barco.equals("destructor" + String.valueOf(numeroBarco))){
                    casillasUsadasBarco.add(2);
                    panelTableroOponente.getTableroPosicionOponente().getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                }else{
                    if(barco.equals("fragata" + String.valueOf(numeroBarco))){
                        casillasUsadasBarco.add(1);
                        panelTableroOponente.getTableroPosicionOponente().getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                    }
                }
            }
        }
    }

    public boolean funcionesFlota(String barco, int estadoOrientacion, int estadoSentidoOrientacion, int col, int row){
        int casillasAUsar; // Cantidad de casillas que ocupa el barco
        int casillasUsadas = 0; // Determina si las casillas siguientes estan ocupadas para poder desplegar el barco
        int columnaReferencia = 0; // Es la columna de referencia dependiendo si es horizontal o vertical
        int filaReferencia = 0; // Es la fila de referencia dependiendo si es horizontal o vertical
        int nextImage; // Acumulador para mostrar las imagenes en orden
        boolean auxiliar = false; // false si no se puede colocar el barco, de lo contrario true

        if(barco == "portavion"){
            casillasAUsar = 4;
        }else{
            if(barco == "submarino"){
                casillasAUsar = 3;
            }else{
                if(barco == "destructor"){
                    casillasAUsar = 2;
                }else{
                    casillasAUsar = 1;
                }
            }
        }

        // Si la orientacion es horizontal, solo puede usar dos sentidos
        if(estadoOrientacion == 1){
            if(estadoSentidoOrientacion == 3){
                columnaReferencia = 10;
            }else{
                if(estadoSentidoOrientacion == 4){
                    columnaReferencia = 1;
                }
            }

            int ultimasCasillas = Math.abs(col - columnaReferencia);
            if(ultimasCasillas < casillasAUsar-1){
                auxiliar = false;
            }else{
                if(estadoSentidoOrientacion == 3){
                    nextImage = 1;
                    // Determina si las casillas siguientes estan ocupadas ocupadas por otra nave o no
                    for(int casilla=col; casilla < col+casillasAUsar; casilla++){
                        if(panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().get(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    // Si las casillas siguientes no estan ocupadas, se despliega el barco
                    if(casillasUsadas == 0){
                        for(int pic=col; pic < col+casillasAUsar; pic++){
                            panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], 1);
                            panelTableroOponente.getTableroPosicionOponente().getCasillaNombreBarco().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage++;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        auxiliar = false;
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=col; casilla > col-casillasAUsar; casilla--){
                        if(panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().get(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic > col-casillasAUsar; pic--){
                            panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], 1);
                            panelTableroOponente.getTableroPosicionOponente().getCasillaNombreBarco().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getTableroPosicionOponente().getMatriz()[row][pic], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage--;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        auxiliar = false;
                    }
                }
            }
        }else{
            if(estadoSentidoOrientacion == 1){
                filaReferencia = 10;
            }else{
                if(estadoSentidoOrientacion == 2){
                    filaReferencia = 1;
                }
            }

            int ultimasCasillas = Math.abs(row - filaReferencia);
            if(ultimasCasillas < casillasAUsar-1){
                auxiliar = false;
            }else{
                if(estadoSentidoOrientacion == 1){
                    nextImage = 1;
                    for(int casilla=row; casilla < row+casillasAUsar; casilla++){
                        if(panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().get(panelTableroOponente.getTableroPosicionOponente().getMatriz()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic < row+casillasAUsar; pic++){
                            panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], 1);
                            panelTableroOponente.getTableroPosicionOponente().getCasillaNombreBarco().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage++;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        auxiliar = false;
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=row; casilla > row-casillasAUsar; casilla--){
                        if(panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().get(panelTableroOponente.getTableroPosicionOponente().getMatriz()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic > row-casillasAUsar; pic--){
                            panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getTableroPosicionOponente().getCasillasOcupadas().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], 1);
                            panelTableroOponente.getTableroPosicionOponente().getCasillaNombreBarco().put(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getTableroPosicionOponente().getMatriz()[pic][col], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage--;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        auxiliar = false;
                    }
                }
            }
        }
        return auxiliar;
    }

    // Cambia la cantidad disponible del barco ingresado
    public void setCantidadBarco(String barco){
        if(barco.equals("portavion")){
            cantidadPortavion--;
        }else{
            if(barco.equals("submarino")) {
                cantidadSubmarino--;
            }else{
                if(barco.equals("destructor")) {
                    cantidadDestructor--;
                }else{
                    if(barco.equals("fragata")) {
                        cantidadFragata--;
                    }
                }
            }
        }
    }

    // Retorna la cantidad disponible del barco ingresado
    public int getCantidadBarco(String barco){
        int cantidad = 0;
        if(barco.equals("portavion")){
            cantidad = cantidadPortavion;
        }else{
            if(barco.equals("submarino")) {
                cantidad = cantidadSubmarino;
            }else{
                if(barco.equals("destructor")) {
                    cantidad = cantidadDestructor;
                }else{
                    if(barco.equals("fragata")) {
                        cantidad = cantidadFragata;
                    }
                }
            }
        }
        return cantidad;
    }

    // Retorna la cantidad total de naves disponibles
    public int cantidadTotalNaves(){
        return cantidadPortavion + cantidadSubmarino + cantidadDestructor + cantidadFragata;
    }
}