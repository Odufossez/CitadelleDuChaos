package io.github.odufossez.update.Items;

public class Item {
    protected String name;
    protected String description;
    protected int numero;
    protected boolean isDansInventaire;

    Item(String name, String description, int numero) {
        this.name = name;
        this.description = description;
        this.numero = numero;
        this.isDansInventaire = false;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getNumero() {
        return numero;
    }

    public void setEtat(boolean etat) {
        isDansInventaire = etat;
    }

    public boolean isDansInventaire() {
        return isDansInventaire;
    }

    public String toString() {
        return name;
    }
}
