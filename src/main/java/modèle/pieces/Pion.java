package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.iLigne;

public class Pion extends Piece implements iLigne {

    public Pion(boolean blanc, Partie partie) {
        super(blanc, partie);
        maxX = 2;
        nom = "\u256F";
    }

    @Override
    public int[][] deplacementPossible() {
        int[] deplacementX = deplacementX();
        int[][] deplacement = new int[deplacementX.length][2];
        for (int i = 0; i<deplacement.length; i++){
            deplacement[i][0] = deplacementX[i];
            deplacement[i][0] = emplacement[1];
        }
        return deplacement;
    }

    @Override
    public int[] deplacementX() {
        int[] move = new int[this.partie.getTaillePartie()];
        for(int i=0 ;emplacement[0]+i<partie.getTaillePartie() && emplacement[0]+i<maxX; i++){
            move[i] = emplacement[0]+i;
        }
        return move;
    }

    public void setMaxX(int x){
        this.maxX = x;
    }
}
