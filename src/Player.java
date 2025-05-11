public class Player {
    public String name;
    public int studyhours;
    public int coins;

    public Player(DataBase.UserData userData) {
        this.name = userData.characterName;
        this.studyhours = 0;
        this.coins = userData.coins;
    }

    public void registerStudyhours(int hours) {
        this.studyhours += hours;
        this.coins += hours * 10; // 10 coins per timme
    }

    public int getCoins() {
        return coins;
    }

    public String getName() {
        return name;
    }
}
