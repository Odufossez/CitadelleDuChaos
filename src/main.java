import java.util.Scanner;
//non défintif
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Player player = new Player();
        Monster hydra = new Monster();
        Dice  dice = new Dice();

        System.out.println("Entrer le nom du joueur : ");
        player.pseudo = input.nextLine();

        player.luck = dice.soloDice()+6;
        player.hability = dice.soloDice()+6;
        player.vitality = dice.doubleDice()+12;
        player.magic = dice.doubleDice()+6;

        System.out.println(player.toString());

        hydra.name = "hydra";
        hydra.vitality = 17;
        hydra.habiliy = 10;

        System.out.println(hydra.toString());
    }
}
