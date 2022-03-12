package myProject;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PanelTablero extends JPanel {
    private Tableros tableroPosicion, tableroPrincipal;
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private JLabel nombreTableroPosicion, nombreTableroPrincipal;
    private String abecedario[];
    //private HashMap<JLabel, Integer> casillasOcupadas; // Si value es 1, el JLabel esta ocupado, de lo contrario 0

    public PanelTablero(){
        iniciar();
    }

    public void iniciar(){
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gb);
        this.setBackground(Color.CYAN);

        //casillasOcupadas = new HashMap<>();

        // Panel tablero posicion
        nombreTableroPosicion = new JLabel("T A B L E R O   P O S I C I O N");
        nombreTableroPosicion.setForeground(new Color(0, 0, 0, 230));
        nombreTableroPosicion.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(nombreTableroPosicion, gbc);

        panelTableroPosicion = new JPanel(new GridLayout(11, 11));
        panelTableroPosicion.setPreferredSize(new Dimension(400, 400));
        panelTableroPosicion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPosicion.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,15,0,15);
        this.add(panelTableroPosicion, gbc);

        // Panel tablero principal
        nombreTableroPrincipal = new JLabel("T A B L E R O   P R I N C I P A L");
        nombreTableroPrincipal.setForeground(new Color(0, 0, 0, 230));
        nombreTableroPrincipal.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(nombreTableroPrincipal, gbc);

        panelTableroPrincipal = new JPanel(new GridLayout(11, 11));
        panelTableroPrincipal.setPreferredSize(new Dimension(400, 400));
        panelTableroPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        panelTableroPrincipal.setBackground(Color.BLACK);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,15,0,15);
        this.add(panelTableroPrincipal, gbc);

        tableroPosicion = new Tableros();
        tableroPrincipal = new Tableros();
        abecedario = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                if(row == 0 && col == 0){
                    tableroPosicion.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                    tableroPrincipal.getMatriz()[row][col] = new JLabel("", SwingConstants.CENTER);
                }else{
                    if(row == 0 && col > 0){
                        tableroPosicion.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                        tableroPrincipal.getMatriz()[row][col] = new JLabel(abecedario[col-1], SwingConstants.CENTER);
                    }else{
                        if(row > 0 && col == 0){
                            tableroPosicion.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                            tableroPrincipal.getMatriz()[row][col] = new JLabel(String.valueOf(row), SwingConstants.CENTER);
                        }else{
                            tableroPosicion.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                            tableroPrincipal.getMatriz()[row][col] = new JLabel(new ImageIcon(getClass().getResource("/recursos/enemy.png")), SwingConstants.CENTER);
                        }
                    }
                }
                tableroPosicion.getMatriz()[row][col].setOpaque(true);
                tableroPosicion.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPosicion.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                tableroPrincipal.getMatriz()[row][col].setOpaque(true);
                tableroPrincipal.getMatriz()[row][col].setBackground(Color.WHITE);
                tableroPrincipal.getMatriz()[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                panelTableroPosicion.add(tableroPosicion.getMatriz()[row][col]);
                panelTableroPrincipal.add(tableroPrincipal.getMatriz()[row][col]);
            }
        }
    }

    // Retorna la matriz posicion
    public JLabel[][] getMatrizPosicion(){
        return tableroPosicion.getMatriz();
    }

    // Retorna la matriz principal
    public JLabel[][] getMatrizPrincipal(){
        return tableroPrincipal.getMatriz();
    }

    // Retorna el Map casillasOcupadas
    public HashMap getCasillasOcupadas(){
        return tableroPosicion.getCasillasOcupadas();
    }
}