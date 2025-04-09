package Items;

public class Item {
    private String name;
    private String description;
    private int numero;
    
    Item(String name, String description, int numero) {
        this.name = name;
        this.description = description;
        this.numero = numero;
    }
    
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getNumero() {
        return numero;
    }
}
