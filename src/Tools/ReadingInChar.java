package io.github.odufossez.update.Tools;

public class ReadingInChar {
    public static final char[] tabAlphabet = { 'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' ,'h','i','j','k','l','m','n','o'
            ,'p','q','r','s','p','q','v','w','x','y','z'};

    public static final char RETURN = 0x1B;


    public static char readChar(){
        while (!StdDraw.hasNextKeyTyped()){continue;}
        return StdDraw.nextKeyTyped();
    }

    public static int getCharIndex(char c){
        for (int i = 0; i < tabAlphabet.length-1; i++) {
            if (tabAlphabet[i] == c) return i;
        }
        return -1;
    }
}
