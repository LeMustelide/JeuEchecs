package vues;

import modèle.Case;
import modèle.Joueur;

import java.util.Scanner;

public class PartieVue {

    public void afficherPlateau(Case[][] cases){
        for(Case[] ligne:cases) {
            for (Case c : ligne) {
                System.out.print((c.getPiece() != null) ? c.getPiece().getNom() : "_");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public String nomJoueur(int num){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur "+num+" : ");
        return sc.nextLine();
    }

    public String choixPiece(Joueur joueur){
        Scanner sc = new Scanner(System.in);
        System.out.println(joueur.getNom()+" choissez une pièce (X Y): ");
        return sc.nextLine();
    }

    public String coup(Joueur joueur){
        Scanner sc = new Scanner(System.in);
        System.out.println("A "+joueur.getNom()+" de jouer (X Y): ");
        return sc.nextLine();
    }
}
