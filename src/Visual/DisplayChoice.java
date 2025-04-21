package com.badlogic.citadel.Visual;

import Tools.StdDraw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayChoice {
    private static int choiceY;

    //TODO pour la v1.01 aligner sur le centre du rectangle.


    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     */
    public static void choice(String choice1 , String choice2){
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

        StdDraw.show();
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 3 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     */
    public static void choice(String choice1 , String choice2, String choice3){
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

        StdDraw.show();
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     */
    public static void choice(String choice1 , String choice2, String choice3 , String choice4){
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

        StdDraw.show();

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     * @param choice5 : path vers le txt du choix 5
     */
    public static void choice(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
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
        StdDraw.show();

    }

}
