package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.*;

public class Tour extends Piece implements iLigne, iColonne {

    public Tour(boolean blanc, Partie partie, int[] emplacement) {
        super(blanc, partie, emplacement);
        maxX = partie.getTaillePartie();
        maxY = partie.getTaillePartie();
        nom = " \u265c";
    }

    @Override
    public int[][] deplacementPossible() {
        int index = 0;
        int[] deplacementX = deplacementX();
        int[] deplacementY = deplacementY();
        int[][] deplacement = new int[deplacementX.length+deplacementY.length][2];
        for (int i = 0; i<deplacementX.length; i++){
            deplacement[i][0] = deplacementX[i];
            deplacement[i][1] = emplacement[1];
            index = i;
        }
        for (int i = 0; i<deplacementY.length; i++){
            deplacement[index+i][1] = deplacementY[i];
            deplacement[index+i][0] = emplacement[0];
        }
        return deplacement;
    }

    @Override
    public int[] deplacementY() {
        int[] move = new int[this.partie.getTaillePartie()-1];
        for(int i=1 ;emplacement[1]+i<partie.getTaillePartie() && i<maxY; i++){
            move[i-1] = emplacement[1]+i;
        }
        for(int i=1 ;emplacement[1]-i>0 && i<maxY; i++){
            move[i-1] = emplacement[1]-i;
        }
        return move;
    }

    @Override
    public int[] deplacementX() {
        int[] move = new int[this.partie.getTaillePartie()-1];
        for(int i=1 ;emplacement[0]+i<partie.getTaillePartie() && i<maxX; i++){
            move[i-1] = emplacement[0]+i;
        }
        for(int i=1 ;emplacement[0]-i>0 && i<maxX; i++){
            move[i-1] = emplacement[0]-i;
        }
        return move;
    }
}
