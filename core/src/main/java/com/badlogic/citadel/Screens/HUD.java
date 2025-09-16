package com.badlogic.citadel.Screens;
import com.badlogic.citadel.Methods.Player;

public class HUD {
    private Player ply;
    private int currentHealth;
    private int maxHealth;
    private int luck;
    private int maxLuck;

    public HUD(Player player) {
        ply = player;
        currentHealth = ply.getCurrentVitality();
        maxHealth = ply.getVitality();
        luck = ply.getCurrentLuck();
        maxLuck = ply.getLuck();
    }

}
