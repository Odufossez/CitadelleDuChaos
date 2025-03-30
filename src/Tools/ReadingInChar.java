package Tools;

public class ReadingInChar {
    public static char readChar(){
        while (!StdDraw.hasNextKeyTyped()){continue;}
        return StdDraw.nextKeyTyped();
    }
}
