package modèle.pieces;

public interface iPiece {

    int[][] deplacementPossible();

    String getNom();

    void setEmplacement(int[] emplacement);
}
