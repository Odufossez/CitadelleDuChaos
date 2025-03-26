package citadelleduchaos;

public class Combat {
    private Player player;
    private Monster monster;

    public Combat(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public String toString(){
        return player.toString() + " " + monster.toString();
    }

    public int playerTurn(int attack){
        return player.getCurrentHab()+attack;
    }

    public int monsterTurn(int attack){
        return monster.getHability()+attack;
    }

    public void fight(){
        if (monsterTurn(Dice.doubleDice()) > playerTurn(Dice.doubleDice())){
            player.isTouchedInCombat();
        }

        if (monsterTurn(Dice.doubleDice()) < playerTurn(Dice.doubleDice())){
            monster.isTouchedInCombat();
        }
    }
}
