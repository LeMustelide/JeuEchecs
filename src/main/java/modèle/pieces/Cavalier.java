package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.*;

public class Cavalier extends Piece{

    public Cavalier(boolean blanc, Partie partie, int[] emplacement) {
        super(blanc, partie, emplacement);
        nom = " \u2658";
    }

    @Override
    public int[][] deplacementPossible() {
        int[][] deplacement = new int[8][2];

        if(emplacement[0] + 1 < partie.getTaillePartie()){
            deplacement[0][0] = emplacement[0] + 2;
            if(emplacement[1] - 1>=0){
                deplacement[0][1] = emplacement[1] - 1;
            }
        }


        if(emplacement[0] + 2 < partie.getTaillePartie()){
            deplacement[1][0] = emplacement[0] + 2;
            if(emplacement[1] + 1>=0){
                deplacement[1][1] = emplacement[1] + 1;
            }
        }


        if(emplacement[0] + 1 < partie.getTaillePartie()){
            deplacement[2][0] = emplacement[0] + 1;
            if(emplacement[1] + 2>=0){
                deplacement[2][1] = emplacement[1] + 2;
            }
        }


        if(emplacement[0] - 1 < partie.getTaillePartie()){
            deplacement[3][0] = emplacement[0] - 1;
            if(emplacement[1] + 2>=0){
                deplacement[3][1] = emplacement[1] + 2;
            }
        }


        if(emplacement[0] - 2 < partie.getTaillePartie()){
            deplacement[4][0] = emplacement[0] - 2;
            if(emplacement[1] + 1>=0){
                deplacement[4][1] = emplacement[1] + 1;
            }
        }


        if(emplacement[0] - 2 < partie.getTaillePartie()){
            deplacement[5][0] = emplacement[0] - 2;
            if(emplacement[1] - 1>=0){
                deplacement[5][1] = emplacement[1] - 1;
            }
        }


        if(emplacement[0] - 1 < partie.getTaillePartie()){
            deplacement[6][0] = emplacement[0] - 1;
            if(emplacement[1] - 2>=0){
                deplacement[6][1] = emplacement[1] - 2;
            }
        }


        if(emplacement[0] - 2 < partie.getTaillePartie()){
            deplacement[7][0] = emplacement[0] - 2;
            if(emplacement[1] + 1>=0){
                deplacement[7][1] = emplacement[1] + 1;
            }
        }

        return deplacement;
    }
}
