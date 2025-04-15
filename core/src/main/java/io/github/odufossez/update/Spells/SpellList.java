package Spells;

public class SpellList {

    private static final int[] EVENT_COPIE_CONFORME = {};
    private static final int[] EVENT_FAIBLESSE= {};
    private static final int[] EVENT_FEU = {};
    private static final int[] EVENT_FORCE = {};
    private static final int[] EVENT_ILLUSION = {};
    private static final int[] EVENT_LEVITATION = {};
    private static final int[] EVENT_OR_DU_SOT = {};
    private static final int[] EVENT_PROTECTION = {};
    private static final int[] EVENT_TELEPATHIE = {};

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

    public static boolean sortInEvent(int sort, int event){
        switch (sort) {
            case 0,2,6:{
                return true;
            }
            case 1:{
                for (int e : EVENT_COPIE_CONFORME){
                    if (event == e){ return true; }
                }
                return false;
            }
            case 3:{
                for(int e : EVENT_FAIBLESSE){
                    if (event == e){ return true; }
                }
                return false;
            }
            case 4:{
                for(int e : EVENT_FEU){ if (event == e){ return true; }}
                return false;
            }
            case 5:{
                for(int e : EVENT_FORCE){ if (event == e){ return true; }}
                return false;
            }
            case 7:{
                for(int e : EVENT_ILLUSION){ if (event == e){ return true; }}
                return false;
            }
            case 8: {
                for (int e : EVENT_LEVITATION){ if (event == e){ return true; }}
                return false;
            }
            case 9: {
                for (int e : EVENT_OR_DU_SOT) {
                    if (event == e) {
                        return true;
                    }
                }
                return false;
            }
            case 10: {
                for (int e : EVENT_PROTECTION){ if (event == e){ return true; }}
                return false;
            }
            case 11: {
                for (int e : EVENT_TELEPATHIE){ if (event == e){ return true; }}
                return false;
            }

        }
        return false;
    }




}
