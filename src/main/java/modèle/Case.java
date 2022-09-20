package modèle;

import modèle.pieces.Piece;

public class Case {
    Piece piece;
    boolean vide;

    public void changerPiece(Piece piece){
        this.piece = piece;
        this.vide = false;
    }

    public void viderCase(){
        this.piece = null;
        this.vide = true;
    }

    public Piece getPiece(){
        return (this.vide)? null : this.piece;
    }
}
