package modèle.pieces;

import controlleur.Partie;
import modèle.deplacement.iDiag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fou extends Piece implements iDiag {
    public Fou(boolean blanc, Partie partie, int[] emplacement) {
        super(blanc, partie, emplacement);
        nom = " \u2657";
        maxX = partie.getTaillePartie();
        maxY = partie.getTaillePartie();
    }

    @Override
    public int[][] deplacementPossible() {
        return deplacementDiag();
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
}
