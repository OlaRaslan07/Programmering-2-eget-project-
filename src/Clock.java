import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Clock {
    public Scanner answer;
    public Character myCharacter;
    public Upgrades upgrades;

    public Clock(Character myCharacter, Upgrades upgrades) {
        this.answer = new Scanner(System.in);
        this.myCharacter = myCharacter;
        this.upgrades = upgrades;
    }

    public void start() {
        boolean running = true;

        while (running) {
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
                    startStudyTimer(minutes);
                    myCharacter.earnCoinsFromStudy(minutes);
                    System.out.println("\nDin plugg session är klar!");
                    System.out.println(myCharacter);
                    break;
                case 2:
                    upgrades.purchaseAccessory();
                    break;
                case 3:
                    running = false;
                    System.out.println("Tack för att du spelade!");
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    public void startStudyTimer(int minutes) {
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
    }
}
