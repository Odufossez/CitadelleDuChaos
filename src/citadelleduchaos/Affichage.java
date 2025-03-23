package citadelleduchaos;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Affichage {
    private static int suiteY;
    private static int choiceY;

    private static final Font bold25 = new Font("Arial", Font.BOLD , 25);

    private static final Font bold15 = new Font("Arial", Font.BOLD , 15);
    private static final Font plain15 = new Font("Arial" , Font.PLAIN , 15);

    private static final Font bold20 = new Font("Arial" , Font.BOLD , 20);
    private static final Font plain20 = new Font("Arial" , Font.PLAIN , 20);

    private static final Font plain18 = new Font("Arial", Font.PLAIN , 18);
    private static final Font bold18 = new Font("Arial", Font.BOLD , 18);

    /**
     * Initialisation des paramètres d'affichage de la fenêtre StdDraw
     */
    public static void paramAffichage() {
        StdDraw.clear();
        /*  Paramétrage de la police et de la fenêtre */
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080); //full screen
        suiteY = 1060;

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(bold15);
    }

    /**
     * Affichage du texte narratif d'event en cours
     * @param path : string menant au fichier .txt contenant le texte
     * @throws IOException : gestion d'une erreur sur le path
     */
    public static void affichageNarration(String path) throws IOException {

        paramAffichage();

        /* Affichage du texte fourni par @path */

        try(FileReader fileReader = new FileReader(path);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;

            while ((line = buff.readLine()) != null) {
                StdDraw.text(-150,suiteY,line);
                suiteY=suiteY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }
    }

    public static void afficheMenuPrincipal(){}

    /**
     * Gestion de l'affichage du menu de création de perso
     * @throws IOException
     */ //TODO potentiellement revoir l'affichage (v1.01)
    public static void afficheCreationPerso() throws IOException {
        paramAffichage();

        StdDraw.setFont(bold25);
        StdDraw.text(100,1000 , "Création du personnage");


        StdDraw.setFont(plain15);

        int x=-1000 , y=500;
        int playerHab = Dice.soloDice()+6;
        int playerEnd = Dice.doubleDice() +12;
        int playerLuck = Dice.soloDice() + 6;
        int playerMagic = Dice.doubleDice() + 6;

        StdDraw.text(x,y , "Force du personnage (habilité au combat) : ");
        StdDraw.text(x+450, y , Integer.toString(playerHab));
        y-=40;
        StdDraw.text(x,y , "Endurance du personnage (nombre de points de vie) : ");
        StdDraw.text(x+450,y, Integer.toString(playerEnd));
        y-=40; //ligne du dessous
        StdDraw.text(x,y , "Chance: ");
        StdDraw.text(x+450,y, Integer.toString(playerLuck));
        y-=40;
        StdDraw.text(x,y,"Formules magiques possibles : ");
        StdDraw.text(x+450,y,Integer.toString(playerMagic));
        y-=100;


        StdDraw.setFont(bold20);
        StdDraw.text(x,y,"Voulez vous relancer les dés ? (Les valeurs changeront)");
        y-=140;


        StdDraw.text(x,y,"a. Oui, relancer");
        StdDraw.text(x+500,y,"e. Non, continuer");

        while(!StdDraw.hasNextKeyTyped()){continue;}
        switch (StdDraw.nextKeyTyped()){
            case 'a': afficheCreationPerso(); break; //oui
            case 'e': //non
                Player player = new Player();
                player.setNewPlayer(playerHab,playerEnd,playerMagic,0,playerLuck);
                afficheMakeGrimoire(player); break;
            default: System.exit(1);
        }
    }

    /**
     * Affichage de la fenêtre pour ajouter les sorts au grimoire
     */
    public static void afficheMakeGrimoire(Player player) throws IOException {
        char tabAlphabet[] = { 'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' ,'h','i','j','k','l','m','n','o'};
        Spells spells = new Spells();
        int counterSpells = 0;

        do {
            StdDraw.clear();
            paramAffichage();
            affichePrec();
            StdDraw.setFont(bold25);
            StdDraw.text(0,1000 , "Grimoire");
            StdDraw.setFont(bold15);
            StdDraw.text(-1500,-900 , "Sorts disponibles : " + player.getMagic());
            StdDraw.text(-1500 , -860 , "Sorts sélectionnés : " + counterSpells);

            //liste des sorts avec les descriptions
            int x = -1200 , y = 800;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(bold18);
                StdDraw.textLeft(x,y , tabAlphabet[i] + " " + Spells.getSpellName(i));
                x=1800;
                StdDraw.setFont(plain18);
                StdDraw.textRight(x,y, Spells.getSpellDescription(i));
                y-=100;
                x = -1200;
            }

            //Construction du tableau de quantité de sorts actuels
            x = -1800;
            y = -500;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(bold15);
                StdDraw.textLeft(x,y , Spells.getSpellName(i));
                StdDraw.setFont(plain15);
                y-=40;
                StdDraw.textRight(x,y, Integer.toString(player.getCountSpell(i)));
                y+=40;
                x+=300;
            }

            while(!StdDraw.hasNextKeyTyped()){continue;} //attendre une touche
            switch (StdDraw.nextKeyTyped()){
                case 'a' : player.setSpelltInGrimoire(0,counterSpells); counterSpells++; break;
                case 'b' : player.setSpelltInGrimoire(1,counterSpells); counterSpells++; break;
                case 'c' : player.setSpelltInGrimoire(2,counterSpells); counterSpells++; break;
                case 'd' : player.setSpelltInGrimoire(3,counterSpells); counterSpells++; break;
                case 'e' : player.setSpelltInGrimoire(4,counterSpells); counterSpells++; break;
                case 'f' : player.setSpelltInGrimoire(5,counterSpells); counterSpells++; break;
                case 'g' : player.setSpelltInGrimoire(6,counterSpells); counterSpells++; break;
                case 'h' : player.setSpelltInGrimoire(7,counterSpells); counterSpells++; break;
                case 'i' : player.setSpelltInGrimoire(8,counterSpells); counterSpells++; break;
                case 'j' : player.setSpelltInGrimoire(9,counterSpells); counterSpells++; break;
                case 'k' : player.setSpelltInGrimoire(10,counterSpells); counterSpells++; break;
                case 'l' : player.setSpelltInGrimoire(11,counterSpells); counterSpells++; break;
                case 'w' : {
                    if (counterSpells>0){
                        counterSpells--;
                        player.setSpelltInGrimoire(13,counterSpells);
                    } else {
                        afficheCreationPerso();
                    }
                    break;
                }
                default: continue;
            }

        }while(!player.grimoireIsFull());
    }

    /**
     * Affiche un écran qui résume les choix précédents et permet de changer seulement les sorts ou tous les rolls
     * @param player
     */
    public static void confirmScreen(Player player){
        afficheSuite();

        StdDraw.setFont(bold25);
        StdDraw.text(0,1000 , "Résumé");
        StdDraw.setFont(plain18);
        StdDraw.textLeft(-1200,800 , "ëtes vous satisfait de cette construction ?");

        //Affichage du résumé des sorts
        StdDraw.setFont(bold18);
        StdDraw.textLeft(-1200 , 600 , "Sorts");
        StdDraw.setFont(plain15);
        int x = -1200 , y = 400;
        for (int i=0 ; i<12 ; i++){
            if(player.getCountSpell(i)>0){
                StdDraw.textLeft(x,y , Spells.getSpellName(i) + " " + player.getCountSpell(i));
                y-=40;
            }
        }

        //Affichage des caractéristiques du personnage
        StdDraw.setFont(bold18);
        StdDraw.textRight(1200 , 600 , "Caractéristiques");
        StdDraw.setFont(plain15);
        x = 1200 ; y = 400;
        StdDraw.textRight(x,y , "Habilité : " + player.getHability());
        y-=40;
        StdDraw.textRight(x,y, "Endurance : " + player.getVitality());
        y-=40;
        StdDraw.textRight(x,y, "Chance : " + player.getLuck());
    }


    /**
     * Fonction pour afficher la flèche permettant de passer à la suite
     */
    public static void afficheSuite(){
        StdDraw.line(1000 ,suiteY-200,1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(1000 , suiteY-60 , 1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(1000 , suiteY-200 , 1200 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(1100 , suiteY-60 , "é");
    }

    /**
     * Fonction pour afficher la flèche permettant de revenir en arrière notamment dans la création du grimoire
     */
    public static void affichePrec(){
        StdDraw.line(-1000 ,suiteY-200,-1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(-1000 , suiteY-60 , -1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(-1000 , suiteY-200 , -1200 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(-1050 , suiteY-140 , "w");
    }

    //TODO pour la v1.01 aligner sur le centre du rectangle.
    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     */
    public static void afficheDouble(String choice1 , String choice2){
        StdDraw.rectangle(-1000,-1000,1000,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1020,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(1000,-1000,1000,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1040,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 3 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     */
    public static void afficheTriple(String choice1 , String choice2, String choice3){
        StdDraw.rectangle(-1920,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1320,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-640,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-40,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(640,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1000,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     */
    public static void afficheQuad(String choice1 , String choice2, String choice3 , String choice4){
        StdDraw.rectangle(-1920,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-960,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(0,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(960,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice4);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1300,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     * @param choice5 : path vers le txt du choix 5
     */
    public static void afficheCinq(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
        int halfWidht = 768;
        StdDraw.rectangle(-1920,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-1152,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-900,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-384,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(0,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(384,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice4);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(900,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(1152,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice5);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }
}
