package myProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class GUI_Principal extends JFrame {

    public static final String PATH ="/recursos/";
    private Header headerProject;
    private JButton ayuda, creditos, comenzarPartida, movimientosEnemigo;
    private Escucha escucha;
    private JPanel contentPane;
    private TitledBorder titulo1, titulo2;
    private Border blackline;
    private PintarTablero pintarTablero;

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
        this.setSize(1000,700);
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
        getContentPane().setLayout(new BorderLayout(0,0));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.CYAN);
        getContentPane().add(panelPrincipal,BorderLayout.CENTER);
        panelPrincipal.setLayout(new BorderLayout(0,0));

        JPanel panelSup = new JPanel();
        panelSup.setBackground(Color.CYAN);
        panelPrincipal.add(panelSup,BorderLayout.NORTH);
        panelSup.setLayout(new FlowLayout(FlowLayout.CENTER,194,0));

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.CYAN);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER,200,0));

        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.cyan);
        panelPrincipal.add(panelCentral,BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0,0));

        // Create Listener Object and Control Object
        escucha = new Escucha();

        // Set up JComponents
        // JComponents de la parte superior
        // Titulo
        headerProject = new Header("B A T A L L A   N A V A L", Color.CYAN);
        panelSup.add(headerProject,FlowLayout.LEFT);

        // Creación botón ayuda
        ayuda = new JButton("", new  ImageIcon(getClass().getResource(PATH+"signo.png")));
        ayuda.addActionListener(escucha);
        ayuda.setBackground(Color.CYAN);
        ayuda.setFocusable(false);
        ayuda.setBorder(null);
        panelSup.add(ayuda,FlowLayout.CENTER);

        // Creación botón créditos
        creditos = new JButton("", new ImageIcon(getClass().getResource(PATH+"team.png")));
        creditos.addActionListener(escucha);
        creditos.setBackground(Color.CYAN);
        creditos.setFocusable(false);
        creditos.setBorder(null);
        panelSup.add(creditos,FlowLayout.LEFT);

        // JComponents de la parte central
        // Tablero
        pintarTablero = new PintarTablero();
        panelCentral.add(pintarTablero, BorderLayout.CENTER);

        //JComponents de la parte Inferior
        // Creación de botón comenzar partida
        comenzarPartida = new JButton("Comenzar partida", new ImageIcon(getClass().getResource(PATH+"play.png")));
        comenzarPartida.addActionListener(escucha);
        comenzarPartida.setBackground(Color.CYAN);
        comenzarPartida.setFocusable(false);
        comenzarPartida.setBorder(null);
        panelInferior.add(comenzarPartida,FlowLayout.LEFT);

        // Creación de botón de movimientos del oponente
        movimientosEnemigo = new JButton("Movimientos oponente", new ImageIcon(getClass().getResource(PATH+"enemy.png")));
        movimientosEnemigo.addActionListener(escucha);
        movimientosEnemigo.setBackground(Color.CYAN);
        movimientosEnemigo.setFocusable(false);
        movimientosEnemigo.setBorder(null);
        panelInferior.add(movimientosEnemigo,FlowLayout.CENTER);
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

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
