package myProject;

public class Combate {
    private PanelTablero panelTablero;
    private PanelTableroOponente panelTableroOponente;

    public Combate(PanelTablero _panelTablero, PanelTableroOponente _panelTableroOponente){
        this.panelTablero =_panelTablero;
        this.panelTableroOponente = _panelTableroOponente;
    }

    // Busca las casillas ocupadas por naves del tablero posicion del oponente y las marca en el tablero principal del usuario
    public void usuarioVsOponente(){
        for(int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                if(panelTableroOponente.getTableroOponente("posicion").getCasillasOcupadas().get(panelTableroOponente.getTableroOponente("posicion").getMatriz()[row][col]) == Integer.valueOf(1)){
                    panelTablero.getTablero("principal").getCasillasOcupadas().put(panelTablero.getTablero("principal").getMatriz()[row][col], 1);
                }
            }
        }
    }

    // Busca las casillas ocupadas por naves del tablero posicion del usuario y las marca en el tablero principal del oponente
    public void oponenteVsUsuario(){
        for(int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                if(panelTablero.getTablero("posicion").getCasillasOcupadas().get(panelTablero.getTablero("posicion").getMatriz()[row][col]) == Integer.valueOf(1)){
                    panelTableroOponente.getTableroOponente("principal").getCasillasOcupadas().put(panelTableroOponente.getTableroOponente("principal").getMatriz()[row][col], 1);
                }
            }
        }
    }
}
