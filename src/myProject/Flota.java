package myProject;

import javax.swing.*;

public class Flota {
    public static final String PATH ="/recursos/";
    private JButton portaavion, destuctor, fragata, submarino;
    private ImageIcon imageDestructor, imagePortaavion, imageFragata, imageSubmarino;

    public Flota (){
        barcos();
    }

    public void barcos(){
        // Imagenes
        imageDestructor = new ImageIcon(getClass().getResource(PATH + "destructor.png"));
        imagePortaavion = new  ImageIcon(getClass().getResource(PATH+"portaavion.png"));
        imageFragata = new ImageIcon(getClass().getResource(PATH+"fragata.png"));
        imageSubmarino = new ImageIcon(getClass().getResource(PATH+"submarino.png"));
        // Botones
        portaavion = new JButton("",imagePortaavion);
        destuctor = new JButton("",imageDestructor);
        fragata = new JButton("",imageFragata);
        submarino = new JButton("",imageSubmarino);
    }
}
