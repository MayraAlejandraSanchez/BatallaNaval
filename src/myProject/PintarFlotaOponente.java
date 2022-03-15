package myProject;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
    private int barcoUsado;
    private ArrayList<Integer> casillasUsadasBarco; // casillas usadas por cada barco

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
        barcoUsado = 1;
        casillasUsadasBarco = new ArrayList<>();
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

    // Relaciona con un map la casilla y la cantidad de casillas que usa el barco ingresado
    public void relacionJLabelBarco(JLabel casilla, String barco, int numeroBarco){
        //Integer aux = numeroBarco-1;
        if(barco.equals("portavion" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
            casillasUsadasBarco.add(4);
            System.out.println("El tamaño es " + casillasUsadasBarco.size());
            System.out.println("barcoUsado es " + barcoUsado);
            panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
            System.out.println(barco);
            System.out.println(panelTableroOponente.getCasillaBarco().get(casilla));
            System.out.println(panelTableroOponente.getCasillaBarco().size());
        }else{
            if(barco.equals("submarino" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                casillasUsadasBarco.add(3);
                System.out.println("El tamaño es " + casillasUsadasBarco.size());
                System.out.println("barcoUsado es " + barcoUsado);
                panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                System.out.println(barco);
                System.out.println(panelTableroOponente.getCasillaBarco().get(casilla));
                System.out.println(panelTableroOponente.getCasillaBarco().size());
            }else{
                if(barco.equals("destructor" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                    casillasUsadasBarco.add(2);
                    System.out.println("El tamaño es " + casillasUsadasBarco.size());
                    System.out.println("barcoUsado es " + barcoUsado);
                    panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                    System.out.println(barco);
                    System.out.println(panelTableroOponente.getCasillaBarco().get(casilla));
                    System.out.println(panelTableroOponente.getCasillaBarco().size());
                }else{
                    if(barco.equals("fragata" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                        casillasUsadasBarco.add(1);
                        System.out.println("El tamaño es " + casillasUsadasBarco.size());
                        System.out.println("barcoUsado es " + barcoUsado);
                        panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                        System.out.println(barco);
                        System.out.println(panelTableroOponente.getCasillaBarco().get(casilla));
                        System.out.println(panelTableroOponente.getCasillaBarco().size());
                    }
                }
            }
        }
        /*
        for(int num=1; num < 11; num++){
            if(barco.equals("portavion" + String.valueOf(numeroBarco)) && num == numeroBarco){
                casillasUsadasBarco.add(4);
                System.out.println("El tamaño es " + casillasUsadasBarco.size());
                System.out.println("barcoUsado es " + barcoUsado);
                panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                break;
            }else{
                if(barco.equals("submarino" + String.valueOf(numeroBarco)) && num == numeroBarco){
                    casillasUsadasBarco.add(3);
                    System.out.println("El tamaño es " + casillasUsadasBarco.size());
                    System.out.println("barcoUsado es " + barcoUsado);
                    panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                    break;
                }else{
                    if(barco.equals("destructor" + String.valueOf(numeroBarco)) && num == numeroBarco){
                        casillasUsadasBarco.add(2);
                        System.out.println("El tamaño es " + casillasUsadasBarco.size());
                        System.out.println("barcoUsado es " + barcoUsado);
                        panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                        break;
                    }else{
                        if(barco.equals("fragata" + String.valueOf(numeroBarco)) && num == numeroBarco){
                            casillasUsadasBarco.add(1);
                            System.out.println("El tamaño es " + casillasUsadasBarco.size());
                            System.out.println("barcoUsado es " + barcoUsado);
                            panelTableroOponente.getCasillaBarco().put(casilla, casillasUsadasBarco.get(casillasUsadasBarco.size()-1));
                            break;
                        }
                    }
                }
            }
        }

         */
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
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[row][pic], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage++;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(col);
                        //System.out.println("Casillas usadas es " + casillasUsadas);
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
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[row][pic], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[row][pic], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage--;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(col);
                        //System.out.println("Casillas usadas es " + casillasUsadas);
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
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[pic][col], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[pic][col], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage++;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        //System.out.println("Casillas usadas es " + casillasUsadas);
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
                            panelTableroOponente.getCasillaNombreBarco().put(panelTableroOponente.getMatrizPosicion()[pic][col], barco + String.valueOf(barcoUsado));
                            relacionJLabelBarco(panelTableroOponente.getMatrizPosicion()[pic][col], barco + String.valueOf(barcoUsado), barcoUsado);
                            nextImage--;
                            auxiliar = true;
                        }
                        barcoUsado++;
                    }else{
                        System.out.println("Oye, No se puede colocar aqui");
                        System.out.println(row);
                        //System.out.println("Casillas usadas es " + casillasUsadas);
                    }
                }
            }
        }
        return auxiliar;
    }

    public void reducirCasillasUsadas(String barco, int numeroBarco){
        if(barco.equals("portavion" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
            for (int row = 1; row < 11; row++) {
                for (int col = 1; col < 11; col++) {
                    if(panelTableroOponente.getCasillaNombreBarco().get(panelTableroOponente.getMatrizPosicion()[row][col]) != null){
                        if(panelTableroOponente.getCasillaNombreBarco().get(panelTableroOponente.getMatrizPosicion()[row][col]).equals(barco)){

                        }
                        //panelTableroOponente.getCasillaBarco().replace(panelTableroOponente.getMatrizPosicion()[row][col], panelTableroOponente.getCasillaBarco().get();
                    }
                }
            }
            casillasUsadasBarco.set(numeroBarco-1, casillasUsadasBarco.get(numeroBarco-1)-1);
        }else{
            if(barco.equals("submarino" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                casillasUsadasBarco.set(numeroBarco-1, casillasUsadasBarco.get(numeroBarco-1)-1);
            }else{
                if(barco.equals("destructor" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                    casillasUsadasBarco.set(numeroBarco-1, casillasUsadasBarco.get(numeroBarco-1)-1);
                }else{
                    if(barco.equals("fragata" + String.valueOf(numeroBarco)) /*&& num == numeroBarco*/){
                        casillasUsadasBarco.set(numeroBarco-1, casillasUsadasBarco.get(numeroBarco-1)-1);
                    }
                }
            }
        }
    }

    // Retorna la cantidad de casillas usadas por el barco ingresado
    public int getCasillasUsadas(String barco, int numeroBarco) {
        int casillas = 0;
        for(int num=1; num <11; num++){
            if(barco.equals("portavion" + String.valueOf(numeroBarco)) && num == numeroBarco){
                casillas = casillasUsadasBarco.get(numeroBarco-1);
                break;
            }else{
                if(barco.equals("submarino" + String.valueOf(numeroBarco)) && num == numeroBarco){
                    casillas = casillasUsadasBarco.get(numeroBarco-1);
                    break;
                }else{
                    if(barco.equals("destructor" + String.valueOf(numeroBarco)) && num == numeroBarco){
                        casillas = casillasUsadasBarco.get(numeroBarco-1);
                        //break;
                    }else{
                        if(barco.equals("fragata" + String.valueOf(numeroBarco)) && num == numeroBarco){
                            casillas = casillasUsadasBarco.get(numeroBarco-1);
                            break;
                        }
                    }
                }
            }
        }
        return casillas;
    }

    public int getCasillasUsadasBarco(){
        return casillasUsadasBarco.size();
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
}