package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.*;

public class Tour extends Piece implements iLigne, iColonne {

    public Tour(boolean blanc, Partie partie) {
        super(blanc, partie);
        maxX = partie.getTaillePartie();
        maxY = partie.getTaillePartie();
        nom = "\u265c";
    }

    @Override
    public int[][] deplacementPossible() {
        return new int[0][];
    }

    @Override
    public int[] deplacementY() {
        int[] move = new int[this.partie.getTaillePartie()];
        for(int i=0 ;emplacement[1]+i<partie.getTaillePartie() && emplacement[1]+i<maxY; i++){
            move[i] = emplacement[1]+i;
        }
        return move;
    }

    @Override
    public int[] deplacementX() {
        int[] move = new int[this.partie.getTaillePartie()];
        for(int i=0 ;emplacement[0]+i<partie.getTaillePartie() && emplacement[0]+i<maxX; i++){
            move[i] = emplacement[0]+i;
        }
        return move;
    }
}
