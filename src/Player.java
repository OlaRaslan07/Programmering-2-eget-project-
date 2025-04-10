public class Player {

    public String name;
    public int studyhours;
    public int coins;

    public Player(String name) {
        this.name = name;
        this.studyhours = 0;
        this.coins = 0;

    }

    public void registerStudyhours(int hours) {

        this.studyhours += hours;
        this.coins += hours * 10; // 10 coins per timme
    }

    public int getCoins(){

        return coins;
    }

    public String getName(){
        return name;
    }
}
