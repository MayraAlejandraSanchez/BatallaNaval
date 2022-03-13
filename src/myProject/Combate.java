package myProject;

public class Combate {
    private PanelTablero panelTablero;
    private PanelTableroOponente panelTableroOponente;

    public Combate(PanelTablero _panelTablero, PanelTableroOponente _panelTableroOponente){
        this.panelTablero =_panelTablero;
        this.panelTableroOponente = _panelTableroOponente;
    }

    public void UsuarioVsOponente(){
        for(int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                if(panelTableroOponente.getCasillasOcupadas().get(panelTableroOponente.getMatrizPosicion()[row][col]) == Integer.valueOf(1)){
                    panelTablero.getCasillasOcupadasPrincipal().put(panelTablero.getMatrizPrincipal()[row][col], 1);
                }
            }
        }
    }

    public void OponenteVsUsuario(){
        for(int row = 1; row < 11; row++) {
            for (int col = 1; col < 11; col++) {
                if(panelTablero.getCasillasOcupadas().get(panelTablero.getMatrizPosicion()[row][col]) == Integer.valueOf(1)){
                    //panelTableroOponente.getCasillasOcupadasPrincipal().put(panelTablero.getMatrizPrincipal()[row][col], 1);
                }
            }
        }
    }
}
