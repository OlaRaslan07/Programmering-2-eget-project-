import java.util.Scanner;

public class Connect {
    public DataBase dataBase;
    public DataBase.UserData userData;
    public Character myCharacter;
    public Upgrades upgrades;
    public Player player;
    public Clock clock;
    public Scanner scanner;

    public Connect() {
        scanner = new Scanner(System.in);

        // Använd inloggningssystemet
        loginSystem login = new loginSystem();
        this.dataBase = login.dataBase;
        String loggedInUsername = login.loginOrRegister();

        userData = dataBase.usersData.get(loggedInUsername);

        if (userData != null) {
            System.out.println("\nHej " + userData.username + "!");
            myCharacter = new Character(userData, dataBase);
            upgrades = new Upgrades(myCharacter);
            player = new Player(userData);
            clock = new Clock(myCharacter, upgrades);

            System.out.println("Karaktär skapad: " + myCharacter.getName());
        } else {
            System.out.println("Ingen användardata hittades för användarnamnet: " + loggedInUsername);
        }
    }

    public void startGame() {
        clock.start();
    }
}
