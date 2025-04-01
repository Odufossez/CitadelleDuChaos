package Visual;

import EventsCdC.Events;
import Tools.StdDraw;

import java.io.IOException;

import static Tools.Fonts.plain18;
import static Tools.PathsTo.pathToChoices;
import static Tools.PathsTo.pathToEvents;
import static Tools.StdDraw.show;

public class DisplayEvents {
    /**
     * Affichage du texte d'introduction
     * @throws IOException
     */
    public static void displayIntro() throws IOException {
        Affichage.narration(pathToEvents+"Event_Intro_text.txt");
        Affichage.arrowNext();
        Affichage.arrowPrev();
        show();
    }

    /**
     * Affichage du texte 1 et des options
     * @throws IOException
     */
    public static void displayEvent1() throws IOException {
        Affichage.narration(pathToEvents+"Event_1_text.txt");
        Affichage.choice(pathToChoices+"choice261.txt",pathToChoices+"choice230.txt",
                pathToChoices+"choice20.txt");
        show();
    }

    /**
     * Affichage du texte 2 et des options
     * @throws IOException
     */
    public static void displayEvent2() throws IOException {
        Affichage.narration(pathToEvents+"Event_2_text.txt");
        Affichage.choice(pathToChoices+"choice142.txt",pathToChoices+"choice343.txt");
        show();
    }

    /**
     * Affichage du texte 3 et des options adpaté en fonction de la présence ou non des objets requis
     * @throws IOException
     */
    public static void displayEvent3() throws IOException {
        Affichage.narration(pathToEvents+"Event_3_text.txt");
        Affichage.choice(pathToChoices+"affInventaire.txt" , pathToChoices+"choice366.txt" ,
                pathToChoices+"choice286.txt");
    }
}
