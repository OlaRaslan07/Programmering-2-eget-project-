import java.util.Scanner;

public class Connect {
    public DataBase dataBase;
    public DataBase.UserData userData;
    public Character myCharacter;
    public Upgrades upgrades;
    public Player player;
    public Clock clock;
    public Scanner scanner;
    public QuoteAPI quoteAPI;

    public Connect() {
        scanner = new Scanner(System.in);
        quoteAPI = new QuoteAPI();

        // Använd inloggningssystemet
        loginSystem login = new loginSystem();
        String loggedInUsername = login.loginOrRegister();

        // Use the same database instance from loginSystem
        this.dataBase = login.dataBase;
        userData = dataBase.usersData.get(loggedInUsername);

        if (userData != null) {
            System.out.println("\nHej " + userData.username + "!");

            // Display an inspirational quote after successful login
            String inspirationalQuote = quoteAPI.getRandomQuote();
            System.out.println("\n✨ Dagens inspiration ✨");
            System.out.println(inspirationalQuote);
            System.out.println("-----------------------------------");

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