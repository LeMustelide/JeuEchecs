package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.iLigne;

public class Pion extends Piece implements iLigne {

    public Pion(boolean blanc, Partie partie, int[] emplacement) {
        super(blanc, partie, emplacement);
        maxX = 2;
        nom = " ♙";
    }

    @Override
    public int[][] deplacementPossible() {
        int[] deplacementX = deplacementX();
        int[][] deplacement = new int[deplacementX.length][2];
        for (int i = 0; i<deplacement.length; i++){
            deplacement[i][0] = deplacementX[i];
            deplacement[i][1] = emplacement[1];
        }
        return deplacement;
    }

    @Override
    public int[] deplacementX() {
        int[] move = new int[this.maxX];
        if(!this.blanc){
            for(int i=0 ;emplacement[0]+i<partie.getTaillePartie() && i<maxX; i++){
                move[i] = emplacement[0]+i+1;
            }
        }
        else{
            for(int i=0 ;emplacement[0]-i>0 && i<maxX; i++){
                move[i] = emplacement[0]-(i+1);
            }
        }

        return move;
    }

    public void setMaxX(int x){
        this.maxX = x;
    }
}
