package Items;

public class Epee extends Item{

    private static int niveau;

    Epee(String name, String description, int numero) {
        super(name, description, numero);
        niveau = 0;
    }

   public void upgrade(){
        niveau++;
   }

}
