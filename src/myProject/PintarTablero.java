package myProject;

import javax.swing.*;
import java.awt.*;

public class PintarTablero extends JPanel {
    private int step=1;
    int tableroPosicion [][] = new int [10][10],tableroPrincipal [][] = new int [10][10] ;

    public void start(){
        for (int i = 0; i<10;i++){
            for (int j=0;j<10;j++){
                tableroPosicion[i][j] = 0;
                tableroPrincipal[i][j] = 0;
            }
        }
    }

    public void pintarTablero(Graphics g, int tablero[][] , int x, int y){
        for (int n = 0; n<10;n++){
            for (int m=0;m<10;m++){
                if (tablero[n][m] == 0){
                    g.setColor(Color.BLACK);
                    g.drawRect(x+n*30, y+m*30,30,30);
                }
                tableroPosicion[n][m] = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (step){
            case 1:
                int height = getHeight(), width = getWidth();
                Graphics2D G2D=(Graphics2D) g;
                GradientPaint gp = new GradientPaint(0,0,Color.CYAN,0,height,Color.CYAN);
                G2D.setPaint(gp);
                setBackground(Color.CYAN);
                G2D.fillRect(0,0,width,height);
                pintarTablero(g,tableroPosicion,150,50);
                pintarTablero(g,tableroPrincipal,550,50);
                break;
        }

    }
}
