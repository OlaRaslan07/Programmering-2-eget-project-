import java.util.Scanner;

public class Connect {

    public Character myCharacter;
    public Upgrades upgrades;
    public Player player;
    public Clock clock;
    public Scanner scanner;

    public Connect() {
        scanner = new Scanner(System.in);

        // Använd inloggningssystemet
        loginSystem login = new loginSystem();
        String loggedInUsername = login.loginOrRegister(); // Få det inloggade användarnamnet

        // Skapa karaktär baserat på det inloggade användarnamnet
        System.out.print("\nHej " + loggedInUsername + "!");

        System.out.println("Vad ska din karaktär heta?: ");
        String characterName = scanner.nextLine();

        myCharacter = new Character(characterName);
        upgrades = new Upgrades(myCharacter);
        player = new Player(characterName);
        clock = new Clock(myCharacter, upgrades);

        System.out.println("Karaktär skapad: " + myCharacter.getName());
    }

    public void startGame() {
        clock.start(); // Starta spelet
    }
}
