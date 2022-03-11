package myProject;

import javax.swing.*;

public class PintarFlota {
    private PintarTablero pintarTablero;

    // Constructor
    public PintarFlota(PintarTablero pintarTablero){
        this.pintarTablero = pintarTablero;
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

    public void funcionesFlota(String barco, int estadoOrientacion, int estadoSentidoOrientacion, int col, int row, int casillasUsadas){
        int casillasAUsar = 0;
        int columnaReferencia = 0;
        int filaReferencia = 0;
        int nextImage = 0;

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
                System.out.println("No hay espacio para colocar el portavion");
                System.out.println(col);
            }else{
                if(estadoSentidoOrientacion == 3){
                    nextImage = 1;
                    for(int casilla=col; casilla < col+casillasAUsar; casilla++){
                        if(pintarTablero.getCasillasOcupadas().get(pintarTablero.getMatrizPosicion()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic < col+casillasAUsar; pic++){
                            pintarTablero.getMatrizPosicion()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            pintarTablero.getCasillasOcupadas().put(pintarTablero.getMatrizPosicion()[row][pic], 1);
                            nextImage++;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(col);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=col; casilla > col-casillasAUsar; casilla--){
                        if(pintarTablero.getCasillasOcupadas().get(pintarTablero.getMatrizPosicion()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas--;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic > col-casillasAUsar; pic--){
                            pintarTablero.getMatrizPosicion()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            pintarTablero.getCasillasOcupadas().put(pintarTablero.getMatrizPosicion()[row][pic], 1);
                            nextImage--;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
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
                System.out.println(row);
            }else{
                if(estadoSentidoOrientacion == 1){
                    nextImage = 1;
                    for(int casilla=row; casilla < row+casillasAUsar; casilla++){
                        if(pintarTablero.getCasillasOcupadas().get(pintarTablero.getMatrizPosicion()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic < row+casillasAUsar; pic++){
                            pintarTablero.getMatrizPosicion()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            pintarTablero.getCasillasOcupadas().put(pintarTablero.getMatrizPosicion()[pic][col], 1);
                            nextImage++;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=row; casilla > row-casillasAUsar; casilla--){
                        if(pintarTablero.getCasillasOcupadas().get(pintarTablero.getMatrizPosicion()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas--;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic > row-casillasAUsar; pic--){
                            pintarTablero.getMatrizPosicion()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            pintarTablero.getCasillasOcupadas().put(pintarTablero.getMatrizPosicion()[pic][col], 1);
                            nextImage--;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }
            }
        }
    }
}