import java.util.Scanner; // Importerar Scanner-klassen för att läsa in användarens input

public class Upgrades { // Definierar en offentlig klass som heter Upgrades
    public Character character; // En offentlig variabel av typen Character för att lagra referensen till en karaktär

    // Konstruktorn för Upgrades-klassen
    public Upgrades(Character character) { // Tar emot en Character-parameter
        this.character = character; // Sätter den interna variabeln 'character' till den angivna karaktären
    }

    // Metod för att köpa en accessoar
    public void buyAccessory(String accessory, int cost) { // Tar emot namnet på accessoaren och dess kostnad
        if (character.getCoins() >= cost) { // Kontrollerar om karaktären har tillräckligt med coins


            character.addAccessory(accessory); // Lägger till accessoaren till karaktären
            character.addCoins(-cost); // Dra av kostnaden från karaktärens coins
            System.out.println("Du har köpt: " + accessory); // Meddelar användaren att de har köpt accessoaren


        } else {
            System.out.println("Inte tillräckligt med coins för att köpa " + accessory); // Meddelar användaren att de inte har tillräckligt med coins
        }
    }

    // Metod för att hantera köp av accessoarer
    public void purchaseAccessory() { // Ingen parameter, hanterar köp av accessoarer
        Scanner scanner = new Scanner(System.in); // Skapar en ny Scanner-instans för att läsa in användarens val

        boolean buying = true; // En boolean variabel för att hålla köpprocessen igång
        while (buying) { // En loop som fortsätter så länge 'buying' är true


            System.out.println("\nVälj en accessoar att köpa:"); // Ber användaren att välja en accessoar
            System.out.println("1. Hatt (30 coins)"); // Alternativ 1: Hatt
            System.out.println("2. Skor (50 coins)"); // Alternativ 2: Skor
            System.out.println("3. Kostym (100 coins)"); // Alternativ 3: Kostym
            System.out.println("4. Avsluta köp"); // Alternativ 4: Avsluta köp
            System.out.print("Ditt val: "); // Ber användaren att ange sitt val


            int choice = scanner.nextInt(); // Lagrar användarens val som en integer i variabeln 'choice'

            switch (choice) { // En switch-sats för att hantera användarens val


                case 1: // Om användaren väljer 1
                    buyAccessory("Hatt", 30); // Anropar buyAccessory för att köpa en hatt
                    break; // Avslutar switch-satsen för alternativ 1


                case 2: // Om användaren väljer 2
                    buyAccessory("Skor", 50); // Anropar buyAccessory för att köpa skor
                    break; // Avslutar switch-satsen för alternativ 2


                case 3: // Om användaren väljer 3
                    buyAccessory("Kostym", 100); // Anropar buyAccessory för att köpa en kostym
                    break; // Avslutar switch-satsen för alternativ 3


                case 4: // Om användaren väljer 4
                    buying = false; // Sätter 'buying' till false för att avsluta köpprocessen
                    break; // Avslutar switch-satsen för alternativ 4


                default: // Om användaren anger ett ogiltigt val
                    System.out.println("Ogiltigt val, försök igen."); // Meddelar användaren att valet är ogiltigt
            }
            System.out.println(character); // Skriver ut karaktärens status efter varje köp
        }
    }
}