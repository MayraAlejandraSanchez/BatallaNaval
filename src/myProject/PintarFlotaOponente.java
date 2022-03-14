package myProject;

import javax.swing.*;

public class PintarFlotaOponente {
    private PanelTableroOponente panelTableroOponente;
    private int cantidadPortavion;
    private int cantidadSubmarino;
    private int cantidadDestructor;
    private int cantidadFragata;
    private int casillasUsadasPortavion;
    private int casillasUsadasSubmarino;
    private int casillasUsadasDestructor;
    private int casillasUsadasFragata;

    // Constructor
    public PintarFlotaOponente(PanelTableroOponente _panelTableroOponente){
        this.panelTableroOponente = _panelTableroOponente;
        cantidadPortavion = 1;
        cantidadSubmarino = 2;
        cantidadDestructor = 3;
        cantidadFragata = 4;
        casillasUsadasPortavion = 4;
        casillasUsadasSubmarino = 3;
        casillasUsadasDestructor = 2;
        casillasUsadasFragata = 1;
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

    public void relacionJLabelBarco(JLabel casilla, String barco){
        Integer aux = 0;
        if(barco == "portavion"){
            panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasPortavion);
        }else{
            if(barco == "submarino"){
                panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasSubmarino);
            }else{
                if(barco == "destructor"){
                    panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasDestructor);
                }else{
                    panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasFragata);
                }
            }
        }
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
                System.out.println("No hay espacio para colocar el portavion");
                System.out.println(col);
            }else{
                if(estadoSentidoOrientacion == 3){
                    nextImage = 1;
                    for(int casilla=col; casilla < col+casillasAUsar; casilla++){
                        if(panelTableroOponente.getCasillasOcupadas().get(panelTableroOponente.getMatrizPosicion()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic < col+casillasAUsar; pic++){
                            panelTableroOponente.getMatrizPosicion()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getCasillasOcupadas().put(panelTableroOponente.getMatrizPosicion()[row][pic], 1);
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            nextImage++;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(col);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=col; casilla > col-casillasAUsar; casilla--){
                        if(panelTableroOponente.getCasillasOcupadas().get(panelTableroOponente.getMatrizPosicion()[row][casilla]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=col; pic > col-casillasAUsar; pic--){
                            panelTableroOponente.getMatrizPosicion()[row][pic].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getCasillasOcupadas().put(panelTableroOponente.getMatrizPosicion()[row][pic], 1);
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            nextImage--;
                            auxiliar = true;
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
                        if(panelTableroOponente.getCasillasOcupadas().get(panelTableroOponente.getMatrizPosicion()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic < row+casillasAUsar; pic++){
                            panelTableroOponente.getMatrizPosicion()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getCasillasOcupadas().put(panelTableroOponente.getMatrizPosicion()[pic][col], 1);
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[pic][col], barco);
                            nextImage++;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }else{
                    nextImage = casillasAUsar;
                    for(int casilla=row; casilla > row-casillasAUsar; casilla--){
                        if(panelTableroOponente.getCasillasOcupadas().get(panelTableroOponente.getMatrizPosicion()[casilla][col]) == Integer.valueOf(1)) {
                            casillasUsadas++;
                        }
                    }

                    if(casillasUsadas == 0){
                        for(int pic=row; pic > row-casillasAUsar; pic--){
                            panelTableroOponente.getMatrizPosicion()[pic][col].setIcon(new ImageIcon(getClass().getResource(pathImages(barco, estadoOrientacion, estadoSentidoOrientacion) + String.valueOf(nextImage) + ".png")));
                            panelTableroOponente.getCasillasOcupadas().put(panelTableroOponente.getMatrizPosicion()[pic][col], 1);
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco);
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[pic][col], barco);
                            nextImage--;
                            auxiliar = true;
                        }
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }
            }
        }
        return auxiliar;
    }

    public void reducirCasillasUsadas(int barco){
        if(barco == 4){
            casillasUsadasPortavion--;
        }else{
            if(barco == 3){
                casillasUsadasSubmarino--;
            }else{
                if(barco == 2){
                    casillasUsadasDestructor--;
                }else{
                    casillasUsadasFragata--;
                }
            }
        }
    }

    // Retorna la cantidad de portaviones disponibles
    public void setCantidadPortavion(){
        cantidadPortavion--;
    }

    // Retorna la cantidad de submarinos disponibles
    public void setCantidadSubmarino(){
        cantidadSubmarino--;
    }

    // Retorna la cantidad de destructores disponibles
    public void setCantidadDestructor(){
        cantidadDestructor--;
    }

    // Retorna la cantidad de fragatas disponibles
    public void setCantidadFragata(){
        cantidadFragata--;
    }

    // Retorna la cantidad de portaviones disponibles
    public int getCantidadPortavion(){
        return cantidadPortavion;
    }

    // Retorna la cantidad de submarinos disponibles
    public int getCantidadSubmarino(){
        return cantidadSubmarino;
    }

    // Retorna la cantidad de destructores disponibles
    public int getCantidadDestructor(){
        return cantidadDestructor;
    }

    // Retorna la cantidad de fragatas disponibles
    public int getCantidadFragata(){
        return cantidadFragata;
    }

    // Retorna la cantidad total de naves disponibles
    public int cantidadTotalNaves(){
        return cantidadPortavion + cantidadSubmarino + cantidadDestructor + cantidadFragata;
    }

    // Retorna la cantidad de casillas usadas por el portavion
    public int getCasillasUsadasPortavion() {
        return casillasUsadasPortavion;
    }

    // Retorna la cantidad de casillas usadas por el submarino
    public int getCasillasUsadasSubmarino() {
        return casillasUsadasSubmarino;
    }

    // Retorna la cantidad de casillas usadas por el destructor
    public int getCasillasUsadasDestructor() {
        return casillasUsadasDestructor;
    }

    // Retorna la cantidad de casillas usadas por la fragata
    public int getCasillasUsadasFragata() {
        return casillasUsadasFragata;
    }

    // Cambia la cantidad de casillas usadas por el portavion
    public void setCasillasUsadasPortavion(){
        casillasUsadasPortavion--;
    }

    // Cambia la cantidad de casillas usadas por el submarino
    public void setCasillasUsadasSubmarino(){
        casillasUsadasSubmarino--;
    }

    // Cambia la cantidad de casillas usadas por el destructor
    public void setCasillasUsadasDestructor(){
        casillasUsadasDestructor--;
    }

    // Cambia la cantidad de casillas usadas por la fragata
    public void setCasillasUsadasFragata(){
        casillasUsadasFragata--;
    }
}