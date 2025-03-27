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

    public String fight(int monsterAtk , int playerAtk){
        if (monsterTurn(monsterAtk) > playerTurn(playerAtk)){
            player.isTouchedInCombat();
            return "Le monstre vous a touché !";
        } else if (monsterTurn(monsterAtk) < playerTurn(playerAtk)){
            monster.isTouchedInCombat();
            return "Vous avez touché le monstre !";
        } else {
            return "Vous avez paré vos attaques mutuelles ! ";
        }
    }
}
