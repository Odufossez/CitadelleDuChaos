package com.badlogic.citadel.Methods;

public class Combat {
    private Player player;
    private Monster monster;
    private Monster copyMonster;

    public Combat(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        this.player.setIsInCombat(true,this); //envoie du combat chez le joueur
    }

    public Combat(Player player, Monster monster, Monster copyMonster) {
        this.player = player;
        this.monster = monster;
        this.copyMonster = copyMonster;
    }

    public Monster getMonster() {
        return monster;
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

    public int copyTurn(int attack) { return copyMonster.getHability()+attack; }

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

    public String fightMvM(int monsterAtk , int monsterCopyAtk){
        if (monsterTurn(monsterAtk) > copyTurn(monsterCopyAtk)){
            copyMonster.isTouchedInCombat();
            return "Le monstre a touché votre copie !";
        } else if (monsterTurn(monsterAtk) < copyTurn(monsterCopyAtk)){
            monster.isTouchedInCombat();
            return "Vous avez touché le monstre !";
        } else {
            return "Les monstres ont paré leurs attaques mutuelles ! ";
        }
    }

}
