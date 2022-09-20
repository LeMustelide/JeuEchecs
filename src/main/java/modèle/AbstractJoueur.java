package modèle;

public abstract class AbstractJoueur implements iJoueur{
    String nom;
    boolean blanc;

    public String getNom(){
        return this.nom;
    }

    public void setCouleur(boolean blanc){
        this.blanc = blanc;
    }

    public boolean isBlanc(){
        return this.blanc;
    }
}
