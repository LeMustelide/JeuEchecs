package modèle.pieces;

import controlleur.Partie;

public abstract class Piece implements iPiece{
    boolean blanc;
    String nom;
    Partie partie;
    int maxX;
    int maxY;
    // emplacement[0] = X
    // emplacement[1] = y
    int[] emplacement;

    public Piece(boolean blanc, Partie partie, int[] emplacement){
        this.blanc = blanc;
        this.partie = partie;
        this.emplacement = emplacement;
    }

    public String getNom(){
        return this.nom;
    }

    @Override
    public void setEmplacement(int[] emplacement){
        this.emplacement = emplacement;
    }
}
