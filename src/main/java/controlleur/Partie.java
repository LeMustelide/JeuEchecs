package controlleur;

import modèle.Case;
import modèle.Joueur;
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
    }

    public void lancementPartie(){
        int id = 0;
        String[] in;
        joueurs[0] = new Joueur(vue.nomJoueur(1));
        joueurs[1] = new Joueur(vue.nomJoueur(2));
        do{
            id = (id==0)?1:0;
            vue.afficherPlateau(plateau);
            in = vue.choixPiece(joueurs[id]).split(" ");
            for(int[] coup :plateau[Integer.valueOf(in[0])][Integer.valueOf(in[1])].getPiece().deplacementPossible()){
                System.out.println(coup[0]+" "+coup[1]);
            }
        }while (!victoire());
        plateau[0][0].getPiece().deplacementPossible();
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
