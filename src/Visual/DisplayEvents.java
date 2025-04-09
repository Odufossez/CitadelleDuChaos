package Visual;

import EventsCdC.Events;
import Tools.StdDraw;

import java.io.IOException;

import static Tools.Fonts.plain18;
import static Tools.PathsTo.pathToChoices;
import static Tools.PathsTo.pathToEvents;
import static Tools.StdDraw.show;
import static Visual.Affichage.narration;
import static Visual.DisplayChoice.choice;

/**
 * Classe affichant la narration et les choix des events
 */
public class DisplayEvents {
    /**
     * Affichage du texte d'introduction
     * @throws IOException
     */
    public static void displayIntro() throws IOException {
        narration(pathToEvents+"Event_Intro_text.txt");
        Affichage.arrowNext();
        Affichage.arrowPrev();
        show();
    }

    /**
     * Affichage du texte 1 et des options
     * @throws IOException
     */
    public static void displayEvent1() throws IOException {
        narration(pathToEvents+"Event_1_text.txt");
        choice(pathToChoices+"choice261.txt",pathToChoices+"choice230.txt",
                pathToChoices+"choice20.txt");
        show();
    }

    /**
     * Affichage du texte 2 et des options
     * @throws IOException
     */
    public static void displayEvent2() throws IOException {
        narration(pathToEvents+"Event_2_text.txt");
        choice(pathToChoices+"choice142.txt",pathToChoices+"choice343.txt");
        show();
    }

    /**
     * Affichage du texte 3 et des options
     * @throws IOException
     */
    public static void displayEvent3() throws IOException {
        narration(pathToEvents+"Event_3_text.txt");
        choice(pathToChoices+"choice366.txt" , pathToChoices+"choice286.txt");
    }

    public static void displayEvent4() throws IOException {
        narration(pathToEvents+"Event_4_text.txt");
        choice(pathToChoices+"choice303.txt",pathToChoices+"choice190.txt");
    }

    public static void displayEvent5() throws IOException{
        narration(pathToEvents+"Event_5_text.txt");
        choice(pathToChoices+"choice40.txt",pathToChoices+"choice361.txt");
    }

    public static void displayEvent6() throws IOException{
        narration(pathToEvents+"Event_6_text.txt");
    }

    public static void displayEvent7() throws IOException {
        narration(pathToEvents+"Event_7_text.txt");
        choice(pathToChoices+"choice268.txt",pathToChoices+"choice116.xt");
    }

    public static void displayEvent8() throws IOException{
        narration(pathToEvents+"Event_8_text.txt");
        choice(pathToChoices+"choice268.txt",pathToChoices+"choice116.txt");
    }

    public static void displayEvent9() throws IOException{
        narration(pathToEvents+"Event_9_text.txt");
    }

    public static void displayEvent10(){}
}
