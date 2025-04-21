package io.github.odufossez.update.Items;

public class BrosseACheveux extends Item {
    private int[] usages = {};

    BrosseACheveux(String name, String description, int numero) {
        super(name, description, numero);
    }

    public int[] getUsages() {
        return usages;
    }
}
