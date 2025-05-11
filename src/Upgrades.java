import java.util.Scanner;

public class Upgrades {
    public Character character;
    public Scanner scanner;

    public Upgrades(Character character) {
        this.character = character;
        this.scanner = new Scanner(System.in);
    }

    public void buyAccessory(String accessory, int cost) {
        if (character.getCoins() >= cost) {
            character.addAccessory(accessory);
            character.addCoins(-cost);
            System.out.println("Du har köpt: " + accessory);
        } else {
            System.out.println("Inte tillräckligt med coins för att köpa " + accessory);
        }
    }

    public void purchaseAccessory() {
        Scanner scanner = new Scanner(System.in);

        boolean buying = true;
        while (buying) {
            System.out.println("\nVälj en accessoar att köpa:");
            System.out.println("1. Hatt (30 coins)");
            System.out.println("2. Skor (50 coins)");
            System.out.println("3. Kostym (100 coins)");
            System.out.println("4. Avsluta köp");
            System.out.print("Ditt val: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyAccessory("Hatt", 30);
                    break;
                case 2:
                    buyAccessory("Skor", 50);
                    break;
                case 3:
                    buyAccessory("Kostym", 100);
                    break;
                case 4:
                    buying = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
            System.out.println(character);
        }
    }
}