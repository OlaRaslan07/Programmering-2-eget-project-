
import java.util.Scanner;

public class loginSystem {
    public DataBase dataBase;
    public Scanner scanner;

    public loginSystem() {
        dataBase = new DataBase();
        scanner = new Scanner(System.in);
    }

    public String loginOrRegister() {
        while (true) {
            System.out.println("Vänligen välj ett alternativ:");
            System.out.println("1. Registrera dig");
            System.out.println("2. Logga in");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Ange användarnamn: ");
                String username = scanner.nextLine();
                System.out.print("Ange lösenord: ");
                String password = scanner.nextLine();
                System.out.print("Ange karaktärens namn: ");
                String characterName = scanner.nextLine();

                if (dataBase.registerUser(username, password, characterName)) {
                    System.out.println("Registrering lyckades!");
                    return username;
                } else {
                    System.out.println("Användarnamnet finns redan. Försök igen.");
                }
            } else if (choice == 2) {
                System.out.print("Ange användarnamn: ");
                String username = scanner.nextLine();
                System.out.print("Ange lösenord: ");
                String password = scanner.nextLine();

                DataBase.UserData userData = dataBase.validateUser(username, password);
                if (userData != null) {
                    System.out.println("Inloggning lyckades! Välkommen, " + userData.characterName + "!");
                    System.out.println("Antal coins: " + userData.coins + " coins");
                    return userData.username;
                } else {
                    System.out.println("Fel användarnamn eller lösenord. Försök igen.");
                }
            } else {
                System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

}


