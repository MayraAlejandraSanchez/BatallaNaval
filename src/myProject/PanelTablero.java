package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel {
    private JPanel panelTableroPosicion, panelTableroPrincipal;
    private JLabel nombreTableroPosicion, nombreTableroPrincipal;
    private String abecedario[];

    public PanelTablero(){
        iniciar();
    }

    public void iniciar(){
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gb);
        this.setBackground(Color.CYAN);

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
    }

    // Retorna el JPanel del tablero posicion
    public JPanel getPanelTableroPosicion(){
        return panelTableroPosicion;
    }

    // Retorna el JPanel del tablero principal
    public JPanel getPanelTableroPrincipal(){
        return panelTableroPrincipal;
    }
}