// Det är ett bibliotek som låter dig spara och hämta data med hjälp av ett namn
import java.util.HashMap;
import java.util.Scanner;

    public class loginSystem {
        public static void main(String[] args) {


            //Skapar en HashMap som sparar text–text-par (t.ex. namn → lösenord).
            HashMap<String, String> users = new HashMap<>();

            Scanner scanner = new Scanner(System.in);


            //Kör en oändlig loop – upprepas för alltid (tills du bryter den)
            while (true) {
                System.out.println("Välkommen! Vänligen välj ett alternativ:");
                System.out.println("1. Registrera dig");
                System.out.println("2. Logga in");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    // Registrering
                    System.out.print("Ange användarnamn: ");
                    String username = scanner.nextLine();
                    System.out.print("Ange lösenord: ");
                    String password = scanner.nextLine();

                    if (users.containsKey(username)) {
                        System.out.println("Användarnamnet finns redan. Försök igen.");
                    } else {
                        users.put(username, password); // Lägger till användaren
                        System.out.println("Registrering lyckades!");
                    }
                } else if (choice == 2) {
                    // Inloggning
                    System.out.print("Ange användarnamn: ");
                    String username = scanner.nextLine();
                    System.out.print("Ange lösenord: ");
                    String password = scanner.nextLine();

                    if (users.containsKey(username) && users.get(username).equals(password)) {
                        System.out.println("Inloggning lyckades! Välkommen, " + username + "!");
                    } else {
                        System.out.println("Fel användarnamn eller lösenord. Försök igen.");
                    }
                } else {
                    System.out.println("Ogiltigt val, försök igen.");
                }

            }
        }
    }