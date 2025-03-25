package citadelleduchaos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sauvegarde {
    private String saveName;
    private String savePath = "ressources/saves/save_";
    private int indiceSave; //1 à 3

    /**
     * FICHIER DE SAUVEGARDE
     * player's name TODO v1.x
     * player's vitality currentVit hability currentHab luck gold
     * current event
     * items in line
     * spell's util in line
     */

    public Sauvegarde(){}

    public void newSave(Player player) throws IOException {
        String dataPlayer="test";
        Path path = Paths.get(savePath + indiceSave + ".txt");
        Files.createFile(path);

        FileWriter writer = new FileWriter(savePath + indiceSave + ".txt");
        dataPlayer = Integer.toString(player.getVitality()) + " " + Integer.toString(player.getCurrentVitality()) +
                " " + player.getHability() + " " + player.getCurrentHab() + " " + player.getLuck() + " " + player.getGold();
    }

    public void loadSave(){}


}
