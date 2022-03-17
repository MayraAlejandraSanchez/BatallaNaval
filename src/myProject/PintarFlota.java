package myProject;

import javax.swing.*;
import java.awt.*;

public class PintarFlota {
    private PanelTablero panelTablero;
    private PanelFlota panelFlota;
    private int numBarco;

    // Constructor
    public PintarFlota(PanelTablero _panelTablero, PanelFlota _panelFlota){
        this.panelTablero = _panelTablero;
        this.panelFlota = _panelFlota;
        numBarco = 0; // cantidad de barcos desplegados
    }

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

    public boolean funcionesFlota(String barco, int estadoOrientacion, int estadoSentidoOrientacion, int col, int row){
        int casillasAUsar;
        int casillasUsadas = 0;
        int columnaReferencia = 0;
        int filaReferencia = 0;
        int nextImage;
        boolean auxiliar = false; // false si no pudo colocar el barco, de lo contrario true

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
                System.out.println("No hay espacio para colocar el " + barco);
                panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                System.out.println(col);
            }else{
                if(estadoSentidoOrientacion == 3){
                    nextImage = 1;
                    for(int casilla=col; casilla < col+casillasAUsar; casilla++){
                        if(panelTablero.getTablero("posicion").getCasillasOcupadas().get(panelTablero.getTablero("posicion").getMatriz()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic < col+casillasAUsar; pic++){
                            panelTablero.getTablero("posicion").getMatriz()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTablero.getTablero("posicion").getCasillasOcupadas().put(panelTablero.getTablero("posicion").getMatriz()[row][pic], 1);
                            nextImage++;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                        System.out.println(col);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=col; casilla > col-casillasAUsar; casilla--){
                        if(panelTablero.getTablero("posicion").getCasillasOcupadas().get(panelTablero.getTablero("posicion").getMatriz()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic > col-casillasAUsar; pic--){
                            panelTablero.getTablero("posicion").getMatriz()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTablero.getTablero("posicion").getCasillasOcupadas().put(panelTablero.getTablero("posicion").getMatriz()[row][pic], 1);
                            nextImage--;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                        System.out.println(col);
                        System.out.println("Casillas usadas es " + casillasUsadas);
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
                System.out.println("No hay espacio para colocar el portavion");
                panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                System.out.println(row);
            }else{
                if(estadoSentidoOrientacion == 1){
                    nextImage = 1;
                    for(int casilla=row; casilla < row+casillasAUsar; casilla++){
                        if(panelTablero.getTablero("posicion").getCasillasOcupadas().get(panelTablero.getTablero("posicion").getMatriz()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic < row+casillasAUsar; pic++){
                            panelTablero.getTablero("posicion").getMatriz()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTablero.getTablero("posicion").getCasillasOcupadas().put(panelTablero.getTablero("posicion").getMatriz()[pic][col], 1);
                            nextImage++;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=row; casilla > row-casillasAUsar; casilla--){
                        if(panelTablero.getTablero("posicion").getCasillasOcupadas().get(panelTablero.getTablero("posicion").getMatriz()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic > row-casillasAUsar; pic--){
                            panelTablero.getTablero("posicion").getMatriz()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTablero.getTablero("posicion").getCasillasOcupadas().put(panelTablero.getTablero("posicion").getMatriz()[pic][col], 1);
                            nextImage--;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        panelFlota.getTextoInfoBarcos().setText("No hay espacio para colocar el " + barco);
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }
            }
        }
        return auxiliar;
    }
}