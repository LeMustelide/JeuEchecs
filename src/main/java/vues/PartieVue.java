package vues;

import modèle.Case;

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
}
