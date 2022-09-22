package vues;

import modèle.Case;
import modèle.Joueur;

import java.util.Arrays;
import java.util.Scanner;

public class PartieVue {

    public void afficherPlateau(Case[][] cases){
        int i = 1;
        for(Case[] ligne:cases) {
            System.out.print(i+" ");
            for (Case c : ligne) {
                System.out.print(((c.getPiece() != null) ? c.getPiece().getNom() : " _"));
                System.out.print("");
            }
            i++;
            System.out.println("");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public void afficherDéplacement(int[][] deplacements, Case[][] cases){
        int i = 0, b = 0;
        boolean valid = false;
        for(Case[] ligne:cases) {
            System.out.print(i+1);
            b = 0;
            for (Case c : ligne) {
                for(int[] tab:deplacements){
                    if(tab[0] == i && tab[1] == b){
                        valid = true;
                    }
                }
                System.out.print((c.getPiece() != null ? c.getPiece().getNom() : (valid)?" .":" _"));
                System.out.print(" ");
                b++;
                valid = false;
            }
            i++;
            System.out.println("");
        }
        System.out.println("  1  2  3  4  5  6  7");
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
