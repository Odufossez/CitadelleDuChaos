import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Affichage {
    public static void affichage(String path) throws IOException {

        Font font = new Font("Arial", Font.BOLD , 15);
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080); //full screen

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(font);

        try(FileReader fileReader = new FileReader(path);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            int indiceY = 1060;

            while ((line = buff.readLine()) != null) {
                StdDraw.text(-150,indiceY,line);
                indiceY=indiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }
    }
}
