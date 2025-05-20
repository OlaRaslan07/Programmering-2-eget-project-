
public class Player {
    public String name;
    public int studyhours;
    public int coins;

    public Player(DataBase.UserData userData) {
        this.name = userData.characterName;
        this.studyhours = 0;
        this.coins = userData.coins;
    }
}
