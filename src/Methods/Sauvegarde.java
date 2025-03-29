package Methods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static Tools.PathsTo.savePath;

public class Sauvegarde {
    private String saveName;
    static FileWriter writer;

    /**
     * FICHIER DE SAUVEGARDE
     * player's name TODO v1.01
     * 1.player's vitality currentVit hability currentHab , magic , luck , gold
     * 2.current event
     * 3.items in line
     * 4.spell's util in line
     */

    public Sauvegarde(){}

    /**
     * Création d'un fichier de sauvegarde pour la première fois
     * @param indiceSave
     * @throws IOException
     */
    public static void createSave(int indiceSave) throws IOException{
        Path path = Paths.get(savePath + indiceSave + ".txt");
        Files.createFile(path);

        try{
            writer = new FileWriter(savePath + indiceSave + ".txt");
        }catch(IOException e){
            System.out.println("La sauvegarde ne peut pas se créer");
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Pour la création d'une sauvegarde d'une partie déjà existante
     * @param indiceSave
     * @throws IOException
     */
    public static void newSave(int indiceSave, Player player) throws IOException {
        Path path = Paths.get(savePath + indiceSave + ".txt");
        String dataPlayer = "";

        Files.deleteIfExists(path);
        Files.createFile(path);

        //todo voir pour le fichier disparaisse pas
        try{
            writer = new FileWriter(savePath + indiceSave + ".txt");
        }catch(IOException e){
            System.out.println("La sauvegarde ne peut pas se créer");
            throw new IOException(e.getMessage());
        }

        try{
            dataPlayer = Integer.toString(player.getVitality()) + " " + Integer.toString(player.getCurrentVitality()) +
                " " + player.getHability() + " " + player.getCurrentHab() + " " + player.getMagic() + " "
                    + player.getLuck() + " " + player.getGold() + "\n";
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

    /**
     * chargement des paramètres d'une partie
     * @param indiceSave
     * @return
     * @throws IOException
     */
    public static Player loadSave(int indiceSave) throws IOException {
        Player ply = new Player();
        ply.setIndiceSave(indiceSave); //réassociation du joueur avec le fichier
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

    /**
     * Récupère le numéro de l'évènement associé à indiceSave
     * @param indiceSave le numéro de la sauvegarde
     * @return numEvent le numéro de l'évent
     */
    public static int getCurrentEvent(int indiceSave) throws FileNotFoundException {
        try{
            File saveFile = new File(savePath + indiceSave + ".txt");
            Scanner rdFile = new Scanner(saveFile);
            String line;
            Scanner rdLine = null;
            for (int i = 0; i <2 ; i++) {
                line = rdFile.nextLine();
                rdLine = new Scanner(line);
            }

            return rdLine.nextInt();
        }catch (FileNotFoundException e){
            return -1;
        }
    }

    /**
     * Est ce que la sauvegarde en paramètre existe
     * @param slot numéro de la save
     * @return true si elle existe
     */
    public static boolean doesSaveExist(int slot){
        File file = new File(savePath + slot + ".txt");
        return file.exists();
    }

    /**
     * Permet de savoir s'il existe déjà une sauvegarde
     * @return true s'il y a au moins une sauvegarde sinon false
     */
    public static boolean savesExist(){
        for (int i = 1; i < 4 ; i++) {
            File file = new File(savePath + i + ".txt");
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     * renvoie le premier emplacement de sauvegarde libre
     * @return
     */
    public static int firstEmptySlot(){
        for (int i = 1; i < 4 ; i++) {
            if (!Sauvegarde.doesSaveExist(i)){
                return i;
            }
        }
        return -1;
    }

}
