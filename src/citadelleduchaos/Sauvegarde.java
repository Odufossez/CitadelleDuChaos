package citadelleduchaos;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sauvegarde {
    private String saveName;
    private String savePath = "ressources/saves/save_";
    private int indiceSave; //1 à 3

    /**
     * FICHIER DE SAUVEGARDE
     * player's name TODO v1.x
     * 1.player's vitality currentVit hability currentHab , magic , luck gold
     * 2.current event
     * 3.items in line
     * 4.spell's util in line
     */

    public Sauvegarde(){}

    public void newSave(Player player) throws IOException {
        indiceSave = player.getIndiceSave();
        Path path = Paths.get(savePath + indiceSave + ".txt");
        String dataPlayer = "";
        FileWriter writer;

        Files.deleteIfExists(path);
        Files.createFile(path);

        //todo voir pour le fichier disparaisse pas
        try{
            writer = new FileWriter(savePath + indiceSave + ".txt");
            System.out.println("writer ok");
        }catch(IOException e){
            System.out.println("La sauvegarde ne peut pas se créer");
            throw new IOException(e.getMessage());
        }



        try{
            dataPlayer = Integer.toString(player.getVitality()) + " " + Integer.toString(player.getCurrentVitality()) +
                " " + player.getHability() + " " + player.getCurrentHab() + " " + player.getMagic() + " "
                    + player.getLuck() + " " + player.getGold() + "\n";
            System.out.println(dataPlayer);
            writer.write(dataPlayer);


            dataPlayer = Integer.toString(player.getCurrentEvent()) + "\n";
            writer.write(dataPlayer);

            dataPlayer = "";
            for (int i = 0; i < player.getInventory().size()-1 ; i++) {
                dataPlayer += Integer.toString(player.getInventory().get(i)+1) + " ";
            }
            dataPlayer+="\n";
            writer.write(dataPlayer);

            dataPlayer="";
            for(int i=0 ; i<player.getSpells().length-1 ; i++) {
                dataPlayer += Integer.toString(player.getSpells()[i]) + " ";
            }
            dataPlayer+="\n";
            writer.write(dataPlayer);

            writer.close();

        } catch (IOException e) {
            throw new WriteAbortedException("Something went wrong when writing into the saving file " + indiceSave , e);
        }
    }

    public Player loadSave(int indiceSave) throws IOException {
        Player ply = new Player();
        int tabCarac[] = new int[7];
        ArrayList<Integer> items = new ArrayList<>();
        ArrayList<Integer> spells = new ArrayList<>();

        try{
            File saveFile = new File(savePath + indiceSave + ".txt");
            Scanner rdFile = new Scanner(saveFile);

            //Première ligne - CARACT - INDIRECT
            String line = rdFile.nextLine();
            Scanner rdLine = new Scanner(line);
            int i = 0;
            while (rdLine.hasNextInt()){
                tabCarac[i] = rdLine.nextInt();
                i++;
            }
            ply.setVitality(tabCarac[0]);
            ply.setCurrentVitality(tabCarac[1]);
            ply.setHability(tabCarac[2]);
            ply.setCurrentHab(tabCarac[3]);
            ply.setMagic(tabCarac[4]);
            ply.setLuck(tabCarac[5]);
            ply.setGold(tabCarac[6]);

            ply.setSpellBook();

            //Seconde Ligne - CURRENT EVENT - ATTRIBUTION DIRECTE
            line = rdFile.nextLine();
            rdLine = new Scanner(line);
            ply.setCurrentEvent(rdLine.nextInt());

            //Third Line - ITEMS - REMPLISSAGE DIRECT
            line = rdFile.nextLine();
            rdLine = new Scanner(line);
            while(rdLine.hasNextInt()){
                ply.setInventory(rdLine.nextInt());
            }

            //Fourth line - SPELLS - ATTRIBUTION DIRECTE
            line = rdFile.nextLine();
            rdLine = new Scanner(line);
            i=0;
            while(rdLine.hasNextInt()){
                ply.setSpelltInGrimoire(rdLine.nextInt(),i);
            }

        }catch (FileNotFoundException e){
            throw new FileNotFoundException("File save " + indiceSave + "not found");
        }

        return ply;
    }


}
