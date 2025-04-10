import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Clock {
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);

        System.out.println("Skriv in din karaktärs namn:");
        String name = answer.next();

        Character myCharacter = new Character(name);
        Upgrades upgrades = new Upgrades(myCharacter);


        boolean Running = true;
        while (Running) {
            System.out.println("\nVad vill du göra nu?");
            System.out.println("1. Plugga");
            System.out.println("2. Gå till uppgraderingar");
            System.out.println("3. Avsluta programmet");
            System.out.print("Ditt val: ");
            int choice = answer.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Skriv in tiden du vill plugga i minuter:");
                    int minutes = answer.nextInt();

                    int totalSeconds = minutes * 60;

                    for (int i = totalSeconds; i >= 0; i--) {
                        int remainingHours = i / 3600;
                        int remainingMinutes = (i % 3600) / 60;
                        int remainingSeconds = i % 60;

                        System.out.printf("\rTid kvar: %02d:%02d:%02d", remainingHours, remainingMinutes, remainingSeconds);


                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            System.out.println("Timer avbruten!");
                            break;
                        }
                    }

                    myCharacter.earnCoinsFromStudy(minutes);
                    System.out.println("\nDin plugg session är klar!");
                    System.out.println(myCharacter);

                    break;

<<<<<<< Updated upstream
                case 2:
                    upgrades.purchaseAccessory();
                    break;

                case 3:
                    Running = false;
                    System.out.println("Tack för att du spelade!");
                    break;

                default:
=======

                case 2:
                    upgrades.purchaseAccessory();
                    break;

                case 3:
                    Running = false;
                    System.out.println("Tack för att du spelade!");
                    break;

                default: 
>>>>>>> Stashed changes
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}