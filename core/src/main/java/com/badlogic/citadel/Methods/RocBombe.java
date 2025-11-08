package com.badlogic.citadel.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.badlogic.citadel.Dice.soloDice;

public class RocBombe {
    private int nbJoueur;
    private List<String> listeJoueur;
    private int pactole;
    private Random rand = new Random();

    public RocBombe(int nbJoueur){
        this.nbJoueur = nbJoueur;
        listeJoueur = new ArrayList<>(nbJoueur);
        for (int i = 0; i < nbJoueur; i++) {
            listeJoueur.add("Joueur "+i);
        }
        pactole = nbJoueur*3;
    }

    public ArrayList<String> getJoueurs(){
        return (ArrayList<String>) listeJoueur;
    }

    public int getNbJoueur(){
        return nbJoueur;
    }

    public String getJoueur(int i){
        return listeJoueur.get(i);
    }

    public int getNextJoueur (int currentJoueur){
        int nextJoueur = currentJoueur + 1;

        if (nextJoueur >= listeJoueur.size()){
            nextJoueur = 0;
        }

        return nextJoueur;
    }

    public void eliminateJoueur(int i){
        listeJoueur.remove(i);
    }

    public int premierJoueur(){
        return rand.nextInt(0, nbJoueur-1);
    }

    public int joueurEnJeu(){
        return listeJoueur.size();
    }

    public int getPactole(){
        return pactole;
    }

}
