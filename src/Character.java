import java.util.ArrayList; // Importerar ArrayList-klassen för att använda dynamiska listor
import java.util.List; // Importerar List-gränssnittet för att definiera en lista

public class Character { // Definierar en offentlig klass som heter Character
    public String name; // En offentlig strängvariabel för att lagra karaktärens namn
    public int coins; // En offentlig integervariabel för att lagra antalet coins karaktären har
    public List<String> accessories; // En offentlig lista av strängar för att lagra karaktärens accessoarer

    // Konstruktorn för Character-klassen
    public Character(String name) { // Tar emot ett namn som parameter
        this.name = name; // Sätter karaktärens namn till det angivna namnet
        this.coins = 0; // Initierar coins till 0
        this.accessories = new ArrayList<>(); // Skapar en ny ArrayList för att lagra accessoarer
    }

    // Getter-metod för att hämta karaktärens namn
    public String getName() {
        return name; // Returnerar karaktärens namn
    }

    // Getter-metod för att hämta antalet coins
    public int getCoins() {
        return coins; // Returnerar antalet coins
    }

    // Getter-metod för att hämta listan av accessoarer
    public List<String> getAccessories() {
        return accessories; // Returnerar listan av accessoarer
    }

    // Metod för att lägga till coins
    public void addCoins(int amount) {
        this.coins += amount; // Lägger till det angivna beloppet till karaktärens coins
    }

    // Metod för att lägga till en accessoar
    public void addAccessory(String accessory) {
        accessories.add(accessory); // Lägger till den angivna accessoaren till listan av accessoarer
    }

    // Metod för att beräkna och lägga till coins baserat på studietid
    public void earnCoinsFromStudy(int minutes) {
        int earnedCoins = minutes * 1; // Beräknar antalet coins som tjänas (1 coin per minut)
        addCoins(earnedCoins); // Anropar addCoins för att lägga till de tjänade coinsen
    }

    // Överskriver toString-metoden för att ge en strängrepresentation av karaktären
    @Override
    public String toString() {
        return "Karaktär: " + name + ", Coins: " + coins + ", Accessoarer: " + accessories; // Returnerar en sträng med karaktärens namn, coins och accessoarer
    }
}