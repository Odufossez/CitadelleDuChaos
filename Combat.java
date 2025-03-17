public class Combat {

    private int eventNumber;
    private int nbEnnemies;

    public Combat(){
        int eventNumber = 0;
        int nbEnnemies = 1;
    }

    public Combat(int nbEnnemies , int eventNumber,int hab, int vit){
        this.eventNumber = eventNumber;
        this.nbEnnemies = nbEnnemies;
    }

    public boolean isWon(){
        return this.nbEnnemies == 0;
    }

    public int playerTurn(Player player){
        int hab = player.getHability();
        return Dice.doubleDice()+hab;
    }

    public int monsterTurn(Monster monster){
        int hab = monster.getHabiliy();
        return Dice.doubleDice()+hab;
    }

    public int fight(int playerAttack , int monsterAttack , Monster monster , Player player){
        if (playerAttack > monsterAttack){
            return monster.getVitality()-2;
        } else if (playerAttack < monsterAttack){
            return player.getVitality() -2;
        } else {
            return -1;
        }
    }
}
