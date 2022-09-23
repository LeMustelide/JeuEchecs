package controlleur;

import modèle.Case;
import modèle.Joueur;
import modèle.pieces.Pion;
import modèle.pieces.Tour;
import vues.PartieVue;

public class Partie  implements iPartie{
    private final int TaillePartie = 8;
    private Case[][] plateau = new Case[TaillePartie][TaillePartie];
    private PartieVue vue = new PartieVue();
    private Joueur[] joueurs = new Joueur[2];

    public Partie(){
        for(int i = 0; i<plateau.length; i++){
            for (int a = 0; a<plateau[i].length; a++){
                plateau[i][a] = new Case();
            }
        }
        plateau[0][0].changerPiece(new Tour(false, this, new int[]{0, 0}));
        plateau[0][7].changerPiece(new Tour(false, this, new int[]{0, 7}));
        plateau[7][0].changerPiece(new Tour(true, this, new int[]{7, 0}));
        plateau[7][7].changerPiece(new Tour(true, this, new int[]{7, 7}));

        plateau[1][0].changerPiece(new Pion(false, this, new int[]{1, 0}));
        plateau[1][1].changerPiece(new Pion(false, this, new int[]{1, 1}));
        plateau[1][2].changerPiece(new Pion(false, this, new int[]{1, 2}));
        plateau[1][3].changerPiece(new Pion(false, this, new int[]{1, 3}));
        plateau[1][4].changerPiece(new Pion(false, this, new int[]{1, 4}));
        plateau[1][5].changerPiece(new Pion(false, this, new int[]{1, 5}));
        plateau[1][6].changerPiece(new Pion(false, this, new int[]{1, 6}));
        plateau[1][7].changerPiece(new Pion(false, this, new int[]{1, 7}));

        plateau[6][0].changerPiece(new Pion(true, this, new int[]{6, 0}));
        plateau[6][1].changerPiece(new Pion(true, this, new int[]{6, 1}));
        plateau[6][2].changerPiece(new Pion(true, this, new int[]{6, 2}));
        plateau[6][3].changerPiece(new Pion(true, this, new int[]{6, 3}));
        plateau[6][4].changerPiece(new Pion(true, this, new int[]{6, 4}));
        plateau[6][5].changerPiece(new Pion(true, this, new int[]{6, 5}));
        plateau[6][6].changerPiece(new Pion(true, this, new int[]{6, 6}));
        plateau[6][7].changerPiece(new Pion(true, this, new int[]{6, 7}));
    }

    public void lancementPartie(){
        int id = 0;
        String[] in;
        joueurs[0] = new Joueur(vue.nomJoueur(1));
        joueurs[1] = new Joueur(vue.nomJoueur(2));
        vue.afficherPlateau(plateau);
        do{
            id = (id==0)?1:0;

            in = vue.choixPiece(joueurs[id]).split(" ");
            int[][] coupPossible  = plateau[Integer.valueOf(in[0])][Integer.valueOf(in[1])].getPiece().deplacementPossible();
            vue.afficherDéplacement(coupPossible, plateau);
            /*
            for(int[] coup : coupPossible){
                System.out.println("x:"+coup[0]+" y:"+coup[1]);
            }
            */
        }while (!victoire());
        //plateau[0][0].getPiece().deplacementPossible();
    }

    @Override
    public boolean modifierPlateau(int x, int y) {
        return false;
    }

    @Override
    public boolean victoire() {
        return false;
    }

    @Override
    public int getTaillePartie() {
        return TaillePartie;
    }
}
