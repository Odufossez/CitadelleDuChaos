package com.badlogic.citadel.PlayerRelatedMethods;

public class SpellList {

    //TODO COMPLETER?
    private static final int[] EVENT_COPIE_CONFORME = {};
    private static final int[] EVENT_FAIBLESSE= {};
    private static final int[] EVENT_FEU = {};
    private static final int[] EVENT_FORCE = {};
    private static final int[] EVENT_ILLUSION = {};
    private static final int[] EVENT_LEVITATION = {};
    private static final int[] EVENT_OR_DU_SOT = {};
    private static final int[] EVENT_PROTECTION = {};
    private static final int[] EVENT_TELEPATHIE = {};

    private String name;

    public enum Sorts {
        CHANCE,
        COPIE_CONFORME,
        ENDURANCE,
        FAIBLESSE,
        FEU,
        FORCE,
        HABILITE,
        ILLUSION,
        LEVITATION,
        OR_DU_SOT,
        PROTECTION,
        TELEPATHIE
    }

    public static String getName(SpellList.Sorts s){
        return switch (s) {
            case CHANCE -> "Luck";
            case COPIE_CONFORME -> "Creature Copy";
            case ENDURANCE -> "Stamina";
            case FAIBLESSE -> "Weakness";
            case FEU -> "Fire";
            case FORCE -> "Strength";
            case HABILITE -> "Ability";
            case ILLUSION -> "Illusion";
            case LEVITATION -> "Levitation";
            case OR_DU_SOT -> "Fool's Gold";
            case PROTECTION -> "Protection";
            case TELEPATHIE -> "Telepathy";
            default -> null;
        };
    }

    public static int getNumber(SpellList.Sorts s){
        return switch (s) {
            case CHANCE -> 1;
            case COPIE_CONFORME -> 2;
            case ENDURANCE -> 3;
            case FAIBLESSE -> 4;
            case FEU -> 5;
            case FORCE -> 6;
            case HABILITE -> 7;
            case ILLUSION -> 8;
            case LEVITATION -> 9;
            case OR_DU_SOT -> 10;
            case PROTECTION -> 11;
            case TELEPATHIE -> 12;
            default -> 0;
        };
    }
}
