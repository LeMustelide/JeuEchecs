package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roi extends Piece implements iDiag, iColonne, iLigne{
    public Roi(boolean blanc, Partie partie, int[] emplacement) {
        super(blanc, partie, emplacement);
        nom = "\u2654";
        maxX = 1;
        maxY = 1;
    }

    @Override
    public int[] deplacementY() {
        return new int[]{emplacement[1]+1,emplacement[1]-1};
    }

    @Override
    public int[][] deplacementDiag() {
        List<ArrayList<Integer>> move = new ArrayList<>();
        ArrayList<Integer> coup = new ArrayList<Integer>();

        for(int i=0 ;emplacement[0]+i<partie.getTaillePartie() && emplacement[1]+i< partie.getTaillePartie() && i<maxY; i++){
            move.add(new ArrayList<>(Arrays.asList(emplacement[0]+i,emplacement[1]+i)));
        }
        coup.clear();
        for(int i=0 ;emplacement[0]+i<partie.getTaillePartie() && emplacement[1]-1>0 && i<maxY; i++){
            move.add(new ArrayList<>(Arrays.asList(emplacement[0]+i,emplacement[1]-i)));
        }
        coup.clear();
        for(int i=0 ;emplacement[1]-i>0 && emplacement[0]-1>0 && i<maxY; i++){
            move.add(new ArrayList<>(Arrays.asList(emplacement[1]-i,emplacement[0]-i)));
        }
        coup.clear();
        for(int i=0 ;emplacement[1]-i>0 && emplacement[0]<partie.getTaillePartie() && i<maxY; i++){
            move.add(new ArrayList<>(Arrays.asList(emplacement[1]-i,emplacement[0]+i)));
        }
        coup.clear();
        System.out.println(move.size());

        System.out.println("tt : "+move.get(1).size());
        int[][] re = new int[move.size()][2];
        for (int i = 0; i < move.size(); i++) {
            re[i][0] = move.get(i).get(0);
            re[i][1] = move.get(i).get(1);
        }
        return re;
    }

    @Override
    public int[] deplacementX() {
        return new int[]{emplacement[0]+1,emplacement[0]-1};
    }

    public int[][] concat(int[][] array1, int[][] array2){
        int aLen = array1.length;
        int bLen = array2.length;
        int[][] result = new int[aLen + bLen][2];

        System.arraycopy(array1, 0, result, 0, aLen);
        System.arraycopy(array2, 0, result, aLen, bLen);

        return result;
    }

    @Override
    public int[][] deplacementPossible() {
        int index = 0;
        int[] deplacementX = deplacementX();
        int[] deplacementY = deplacementY();
        int[][] deplacement = new int[8][2];
        for (int i = 0; i<deplacementX.length; i++){
            deplacement[i][0] = deplacementX[i];
            deplacement[i][1] = emplacement[1];
            index = i;
        }
        for (int i = 0; i<deplacementY.length; i++){
            deplacement[index+i][1] = deplacementY[i];
            deplacement[index+i][0] = emplacement[0];
        }
        //return this.concat(deplacementDiag(),deplacement);
        return deplacement;
    }
}
