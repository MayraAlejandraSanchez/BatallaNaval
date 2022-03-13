package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 *
 */
public class GUI_Principal extends JFrame {

    public static final String PATH ="/recursos/";
    public static final String AYUDA ="Batalla Naval es un juego tradicional de estrategia y suerte, que involucra a dos participantes (para este caso un jugador vs el computador).\n"+
            "\nEl objetivo del juego es ser el primero en hundir los barcos del oponente. \n"+"\nCada jugador tiene 2 tableros compuesto por 10 filas y 10 columnas: \n"+
            "\n-> Tablero de posición: Representa tu territorio, en él distribuirás tu flota antes de comenzar la partida y sólo será de observación. Verás la posición de tus barcos \ny los disparos de tu oponente en tu territorio, pero no podrás realizar ningún cambio ni disparo en él. \n"+
            "\n-> Tablero principal: Representa el territorio del enemigo, donde tiene desplegada su flota. Será aquí donde se desarrollen los movimientos (disparos) del jugador tratando \nde hundir los barcos enemigos. Este tablero aparecerá en la pantalla del jugador una vez comience la partida y en él quedarán registrados todos sus movimientos, reflejando \ntanto los disparos al agua como los barcos tocados y hundidos hasta el momento. \n"
            +"\n\nCada jugador tiene una flota de 9 barcos de diferente tamaño, por lo que cada uno ocupará un número determinado de casillas en el tablero: \n"+
            "\n• 1 portaaviones: ocupa 4 casillas "+"\n• 2 submarinos: ocupan 3 casillas cada uno."+"\n• 3 destructores: ocupan 2 casillas cada uno "+"\n• 4 fragatas: ocupan 1 casilla cada uno "
            +"\n\nCada barco puede ser ubicado de manera horizontal o vertical en el tablero de posición. "+"\n\nTerminología y movimientos: \n\n"+"• Agua: cuando se dispara sobre una casilla donde no está colocado ningún barco enemigo. En el tablero principal del jugador aparecerá una X. Pasa el turno a tu oponente."+
            "\n• Tocado: cuando se dispara en una casilla en la que está ubicado un barco enemigo que ocupa 2 o más casillas y se destruye sólo una parte del barco. En el tablero del jugador \naparecerá esa parte del barco con una marca indicativa de que ha sido tocado. El jugador vuelve a disparar. "
            +"\n• Hundido: si se dispara en una casilla en la que está ubicado una fragata (1 casilla) u otro barco con el resto de casillas tocadas, se habrá hundido, es decir, se ha eliminado ese \nbarco del juego. Aparecerá en el tablero principal del jugador, el barco completo con la marca indicativa de que ha sido hundido. El jugador puede volver a disparar, siempre y cuando no hayas\n hundido toda la flota de su enemigo, en cuyo caso habrá ganado. ";
    public  static final String CREDITOS="CRÉDITOS\n" +
            "-> BRAYAN STIVEN SANCHEZ LEON\n" +
            "-> MAYRA ALEJANDRA SANCHEZ SALINAS";
    public static final String INFO = "• 1 portaaviones: ocupa 4 casillas"+"\n• 2 submarinos: ocupan 3 casillas cada uno"+"\n• 3 destructores: ocupan 2 casillas cada uno"+"\n• 4 fragatas: ocupan 1 casilla cada uno";
    private Header headerProject;
    private JButton ayuda, creditos, comenzarPartida, movimientosEnemigo;
    private Escucha escucha;
    private ImageIcon team, help, enemy, play;
    private JPanel panelNorte, panelSur, panelEste, panelCentro;
    private PanelTablero panelTablero;
    private PintarFlota pintarFlota;
    private PanelFlota panelFlota;
    private GUI_Secundaria ventanaOponente;
    private int estadoJuego; // 1 seleccionar barco, 2 seleccionar orientacion del barco, 3 seleccionar sentido del barco, 4 colocar barco en el tablero, 5 combate

    /**
     * Constructor of GUI class
     */
    public GUI_Principal(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        Image image = new ImageIcon(getClass().getResource(PATH+"barcoIcono.png")).getImage();
        this.setIconImage(image);
        this.setUndecorated(false);
        this.setSize(1500,750);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        // Set up JFrame Container's Layout
        panelNorte = new JPanel();
        panelSur = new JPanel();
        panelEste = new JPanel();
        panelCentro = new JPanel();

        // Creación de paneles
        panelNorte.setBackground(Color.cyan);
        panelSur.setBackground(Color.cyan);
        panelEste.setBackground(Color.cyan);
        panelCentro.setBackground(Color.cyan);

        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
        panelEste.setLayout(new FlowLayout(FlowLayout.CENTER,100,60));
        panelCentro.setLayout(new GridLayout(1,1,0,100));

        panelSur.setPreferredSize(new Dimension(100,60));
        panelNorte.setPreferredSize(new Dimension(100,60));
        panelEste.setPreferredSize(new Dimension(1000,60));
        panelCentro.setPreferredSize(new Dimension(600,100));

        this.add(panelNorte,BorderLayout.NORTH);
        this.add(panelSur,BorderLayout.SOUTH);
        this.add(panelEste,BorderLayout.EAST);
        this.add(panelCentro,BorderLayout.CENTER);

        // Estado del juego
        estadoJuego = 1;

        // Create Listener Object and Control Object
        escucha = new Escucha();

        // Creates Flota object
        panelFlota = new PanelFlota();

        // Set up JComponents
        // Imagenes
        team = new ImageIcon(getClass().getResource(PATH + "team.png"));
        help = new  ImageIcon(getClass().getResource(PATH+"signo.png"));
        play = new ImageIcon(getClass().getResource(PATH+"play.png"));
        enemy = new ImageIcon(getClass().getResource(PATH+"enemy.png"));

        // JComponents de la parte superior
        // Titulo
        headerProject = new Header("B A T A L L A   N A V A L", Color.CYAN);
        panelNorte.add(headerProject,FlowLayout.LEFT);

        // Creación botón ayuda
        ayuda = new JButton("", help);
        ayuda.addActionListener(escucha);
        ayuda.setBackground(Color.CYAN);
        ayuda.setFocusable(false);
        ayuda.setBorder(null);
        panelNorte.add(ayuda,FlowLayout.CENTER);

        // Creación botón créditos
        creditos = new JButton("", team);
        creditos.addActionListener(escucha);
        creditos.setBackground(Color.CYAN);
        creditos.setFocusable(false);
        creditos.setBorder(null);
        panelNorte.add(creditos,FlowLayout.LEFT);

        // JComponents de la parte central
        // Tablero
        panelTablero = new PanelTablero();
        pintarFlota = new PintarFlota(panelTablero);
        panelEste.add(panelTablero);

        // Flota
        panelCentro.add(panelFlota);

        //JComponents de la parte Inferior
        // Creación de botón comenzar partida
        comenzarPartida = new JButton("Comenzar partida", play);
        comenzarPartida.addActionListener(escucha);
        comenzarPartida.setBackground(Color.CYAN);
        comenzarPartida.setFocusable(false);
        comenzarPartida.setBorder(null);
        panelSur.add(comenzarPartida,FlowLayout.LEFT);

        // Creacion de botón de movimientos del oponente
        movimientosEnemigo = new JButton("Movimientos oponente", enemy);
        movimientosEnemigo.addActionListener(escucha);
        movimientosEnemigo.setBackground(Color.CYAN);
        movimientosEnemigo.setFocusable(false);
        movimientosEnemigo.setBorder(null);
        panelSur.add(movimientosEnemigo,FlowLayout.CENTER);

        setEscuchaBotones("agregar");
        setVerticalHorizontal("remover");
        setOrientacionSentidoVertical("remover");
        setOrientacionSentidoHorizontal("remover");
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI_Principal miProjectGUI = new GUI_Principal();
        });
    }

    // Agrega o remueve el escucha al boton de cada barco
    public void setEscuchaBotones(String evento){
        if(evento == "agregar"){
            panelFlota.getBotonPortavion().addActionListener(escucha);
            panelFlota.getBotonDestructor().addActionListener(escucha);
            panelFlota.getBotonFragata().addActionListener(escucha);
            panelFlota.getBotonSubmarino().addActionListener(escucha);
        }else{
            panelFlota.getBotonPortavion().removeActionListener(escucha);
            panelFlota.getBotonDestructor().removeActionListener(escucha);
            panelFlota.getBotonFragata().removeActionListener(escucha);
            panelFlota.getBotonSubmarino().removeActionListener(escucha);
        }
    }

    // Agrega o remueve el escucha a los botones Vertical y Horizontal
    public void setVerticalHorizontal(String evento){
        if(evento == "agregar"){
            panelFlota.getBotonVertical().addActionListener(escucha);
            panelFlota.getBotonHorizontal().addActionListener(escucha);
            panelFlota.getBotonVertical().setEnabled(true);
            panelFlota.getBotonHorizontal().setEnabled(true);
        }else{
            panelFlota.getBotonVertical().removeActionListener(escucha);
            panelFlota.getBotonHorizontal().removeActionListener(escucha);
            panelFlota.getBotonVertical().setEnabled(false);
            panelFlota.getBotonHorizontal().setEnabled(false);
        }
    }

    // Agrega o remueve el escucha de los botones verticales
    public void setOrientacionSentidoVertical(String evento){
        if(evento == "agregar"){
            panelFlota.getBotonSup_inf().addActionListener(escucha);
            panelFlota.getBotonInf_sup().addActionListener(escucha);
            panelFlota.getBotonSup_inf().setEnabled(true);
            panelFlota.getBotonInf_sup().setEnabled(true);
        }else{
            panelFlota.getBotonSup_inf().removeActionListener(escucha);
            panelFlota.getBotonInf_sup().removeActionListener(escucha);
            panelFlota.getBotonSup_inf().setEnabled(false);
            panelFlota.getBotonInf_sup().setEnabled(false);
        }
    }

    // Agrega o remueve el escucha de los botones horizontales
    public void setOrientacionSentidoHorizontal(String evento){
        if(evento == "agregar"){
            panelFlota.getBotonDer_izq().addActionListener(escucha);
            panelFlota.getBotonIzq_der().addActionListener(escucha);
            panelFlota.getBotonDer_izq().setEnabled(true);
            panelFlota.getBotonIzq_der().setEnabled(true);
        }else{
            panelFlota.getBotonDer_izq().removeActionListener(escucha);
            panelFlota.getBotonIzq_der().removeActionListener(escucha);
            panelFlota.getBotonDer_izq().setEnabled(false);
            panelFlota.getBotonIzq_der().setEnabled(false);
        }
    }

    // Agrega o remueve el escucha a cada uno de los JLabel de la matriz posicion de PintarTablero
    public void setEscuchaCasillas(String evento){
        if(evento == "agregar"){
            for (int row = 0; row < panelTablero.getMatrizPosicion().length; row++) {
                for (int col = 0; col < panelTablero.getMatrizPosicion()[row].length; col++) {
                    panelTablero.getMatrizPosicion()[row][col].addMouseListener(escucha);
                }
            }
        }else{
            for (int row = 0; row < panelTablero.getMatrizPosicion().length; row++) {
                for (int col = 0; col < panelTablero.getMatrizPosicion()[row].length; col++) {
                    panelTablero.getMatrizPosicion()[row][col].removeMouseListener(escucha);
                }
            }
        }
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==ayuda){
                JOptionPane.showMessageDialog(null,AYUDA,"¿Como se juega batalla naval?",JOptionPane.PLAIN_MESSAGE, help);
            }else{
                if(e.getSource()==creditos){
                    JOptionPane.showMessageDialog(null,CREDITOS,"Créditos",JOptionPane.PLAIN_MESSAGE, team);
                }else{
                    if(e.getSource()==comenzarPartida){



                    }else{
                        if(e.getSource()==movimientosEnemigo){
                            GUI_Secundaria ventanaOponente = new GUI_Secundaria();
                            ventanaOponente.setVisible(true);
                        }else{
                            switch(estadoJuego){
                                case 1:
                                    if(e.getSource() == panelFlota.getBotonPortavion()){
                                        if(panelFlota.getCantidadPortavion() > 0){
                                            panelFlota.setCantidadPortavion();
                                            setEscuchaBotones("remover");
                                            System.out.println("Escoge si quieres ubicarlo vertical u horizontal");
                                            setVerticalHorizontal("agregar");
                                            panelFlota.setNombreBoton("portavion");
                                            estadoJuego = 2;
                                        }else{
                                            System.out.println("No hay mas portaviones disponibles");
                                        }
                                    }else{
                                        if(e.getSource() == panelFlota.getBotonDestructor()){
                                            if(panelFlota.getCantidadDestructor() > 0){
                                                panelFlota.setCantidadDestructor();
                                                setEscuchaBotones("remover");
                                                System.out.println("Escoge si quieres ubicarlo vertical u horizontal");
                                                setVerticalHorizontal("agregar");
                                                panelFlota.setNombreBoton("destructor");
                                                estadoJuego = 2;
                                            }else{
                                                System.out.println("No hay mas destructores disponibles");
                                            }
                                        }else{
                                            if(e.getSource() == panelFlota.getBotonFragata()){
                                                if(panelFlota.getCantidadFragata() > 0){
                                                    panelFlota.setCantidadFragata();
                                                    setEscuchaBotones("remover");
                                                    System.out.println("Escoge si quieres ubicarlo vertical u horizontal");
                                                    setVerticalHorizontal("agregar");
                                                    panelFlota.setNombreBoton("fragata");
                                                    estadoJuego = 2;
                                                }else{
                                                    System.out.println("No hay mas fragatas disponibles");
                                                }
                                            }else{
                                                if(e.getSource() == panelFlota.getBotonSubmarino()){
                                                    if(panelFlota.getCantidadSubmarino() > 0){
                                                        panelFlota.setCantidadSubmarino();
                                                        setEscuchaBotones("remover");
                                                        System.out.println("Escoge si quieres ubicarlo vertical u horizontal");
                                                        setVerticalHorizontal("agregar");
                                                        panelFlota.setNombreBoton("submarino");
                                                        estadoJuego = 2;
                                                    }else{
                                                        System.out.println("No hay mas submarinos disponibles");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 2:
                                    if(e.getSource() == panelFlota.getBotonVertical()){
                                        setVerticalHorizontal("remover");
                                        System.out.println("Escoge cuál sentido quieres usar");
                                        setOrientacionSentidoVertical("agregar");
                                        panelFlota.setOrientacion(0);
                                        estadoJuego = 3;
                                        System.out.println(panelFlota.getOrientacion());//
                                    }else{
                                        if(e.getSource() == panelFlota.getBotonHorizontal()){
                                            setVerticalHorizontal("remover");
                                            System.out.println("Escoge cuál sentido quieres usar");
                                            setOrientacionSentidoHorizontal("agregar");
                                            panelFlota.setOrientacion(1);
                                            estadoJuego = 3;
                                            System.out.println(panelFlota.getOrientacion());//
                                        }
                                    }
                                    break;
                                case 3:
                                    if(e.getSource() == panelFlota.getBotonSup_inf()){
                                        setOrientacionSentidoVertical("remover");
                                        System.out.println("Selecciona la casilla en la que quieres ubicar la nave");
                                        setEscuchaCasillas("agregar");
                                        panelFlota.setSentidoOrientacion(1);
                                        estadoJuego = 4;
                                        System.out.println(panelFlota.getSentidoOrientacion());//
                                    }else{
                                        if(e.getSource() == panelFlota.getBotonInf_sup()){
                                            setOrientacionSentidoVertical("remover");
                                            System.out.println("Selecciona la casilla en la que quieres ubicar la nave");
                                            setEscuchaCasillas("agregar");
                                            panelFlota.setSentidoOrientacion(2);
                                            estadoJuego = 4;
                                            System.out.println(panelFlota.getSentidoOrientacion());//
                                        }else{
                                            if(e.getSource() == panelFlota.getBotonIzq_der()){
                                                setOrientacionSentidoHorizontal("remover");
                                                System.out.println("Selecciona la casilla en la que quieres ubicar la nave");
                                                setEscuchaCasillas("agregar");
                                                panelFlota.setSentidoOrientacion(3);
                                                estadoJuego = 4;
                                                System.out.println(panelFlota.getSentidoOrientacion());//
                                            }else{
                                                if(e.getSource() == panelFlota.getBotonDer_izq()){
                                                    setOrientacionSentidoHorizontal("remover");
                                                    System.out.println("Selecciona la casilla en la que quieres ubicar la nave");
                                                    setEscuchaCasillas("agregar");
                                                    panelFlota.setSentidoOrientacion(4);
                                                    estadoJuego = 4;
                                                    System.out.println(panelFlota.getSentidoOrientacion());//
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    break;
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(estadoJuego){
                case 4:
                    int auxiliar = 0; // Variable para indicar cuando se debe terminar el primer ciclo
                    for (int row = 1; row < 11; row++) {
                        for (int col = 1; col < 11; col++) {
                            if(e.getSource() == panelTablero.getMatrizPosicion()[row][col]) {
                                // Condicional para saber si el usuario pudo colocar el barco
                                if(pintarFlota.funcionesFlota(panelFlota.getNombreBoton(), panelFlota.getOrientacion(), panelFlota.getSentidoOrientacion(), col, row)){
                                    if(panelFlota.cantidadTotalNaves() > 0){
                                        setEscuchaCasillas("remover");
                                        System.out.println("Escoge otro barco");
                                        setEscuchaBotones("agregar");
                                        estadoJuego = 1;
                                    }else{
                                        System.out.println("El combate comienza");
                                        estadoJuego = 5;
                                    }
                                }
                                auxiliar = 1;
                                break;
                            }
                        }
                        if(auxiliar == 1){
                            break;
                        }
                    }
                    break;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}