package com.badlogic.citadel;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
public class Item implements Comparable{
    protected String name;
    protected String description;
    protected int numero; //must be unique for each item
    protected boolean isDansInventaire;
    protected ArrayList<Integer> usages;
    protected TextButton buttonUse;

    public Item(Items items) {
        name = items.toString().toLowerCase();
        numero = items.ordinal();
    }

    public enum Items{
        ALCHEMIST_HEALING_BALM,
        BERRIES,
        CHARMED_AMULET,
        ENCHANTED_BRUSH,
        ENCHANTED_THROWING_DAGGER,
        EXOTIC_FRUITS,
        FRUIT_OF_SILENCE,
        GRASS,
        HALLUCINATING_POTION,
        HOGWEED,
        HOGWEED_ESSENCE,
        JEWEL_OF_LIGHT,
        KEY_COPPER,
        KEY_GREEN,
        KEY_SILVER,
        NEEDLE_KNIFE,
        POCKET_MYRIADE,
        RED_WINE,
        RING_OF_SWORDSMANSHIP,
        SILVER_MIRROR,
        SLUMBERBERRY,
        SPIDER_MAN,
        SWORD,
        WINE_FIRE;

        public static String getName(Items item) {
            switch (item) {
                case ALCHEMIST_HEALING_BALM:
                    return "Healing Balm";
                case BERRIES:
                    return "Berry";
                case CHARMED_AMULET:
                    return "Charmed Amulet";
                case ENCHANTED_BRUSH:
                    return "Enchanted Brush";
                case ENCHANTED_THROWING_DAGGER:
                    return "Enchanted Throwing Dagger";
                case EXOTIC_FRUITS:
                    return "Exotic Fruits";
                case FRUIT_OF_SILENCE:
                    return "Fruit of Silence";
                case GRASS:
                    return "Grass";
                case HALLUCINATING_POTION:
                    return "Hallucinating Potion";
                case HOGWEED:
                    return "Hogweed";
                case HOGWEED_ESSENCE:
                    return "Hogweed Essence";
                case JEWEL_OF_LIGHT:
                    return "Jewel of Light";
                case KEY_COPPER:
                    return "Copper key";
                case KEY_GREEN:
                    return "Green key";
                case KEY_SILVER:
                    return "Silver key";
                case NEEDLE_KNIFE:
                    return "Needle knife";
                case POCKET_MYRIADE:
                    return "Pocket Myriade";
                case RED_WINE:
                    return "Red wine";
                case RING_OF_SWORDSMANSHIP:
                    return "Ring of Swordsmanship";
                case SILVER_MIRROR:
                    return "Silver mirror";
                case SPIDER_MAN:
                    return "Spider Man";
                case SLUMBERBERRY:
                    return "Slumberberry";
                case SWORD:
                    return "Sword";
                case WINE_FIRE:
                    return "Wine of Fire";
                default:
                    return "Unknown Item";
            }
        }
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

    public void setUsages(ArrayList<Integer> uses) {
        usages = uses;
    }

    /**
     * Return true if the item can be useful in this event
     * usages is a table of int which represent the events where the
     * item can be use
     * @param event current event
     * @return true if the item is useful in the current event
     */
    public boolean inEvent(int event){
        for (int usage: usages) {
            if (event == usage) {
                return true;
            }
        }
        return false;
    }

    public void setButtonUse(TextButton btt){
        buttonUse = btt;
    }

    public TextButton getButton(){
        return buttonUse;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Item){
            Item item = (Item) o;
            return this.numero - item.numero;
        }
        return 0;
    }
}
