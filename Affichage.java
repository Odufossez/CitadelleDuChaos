import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Affichage {
    public static void affichage() throws IOException {

        Font font = new Font("Arial" , Font.BOLD , 20);
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080); //full screen

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(font);

        //TODO trouver un moyen de revenir à la ligne
        StdDraw.text(-1900,1000, Files.readString(Path.of("CitadelleDuChaos/ressources/text.txt")));
    }
}
