import java.util.ArrayList;
import java.util.List;

public class Character {
    public String name;
    public int coins;
    public List<String> accessories;


    public Character(String name) {
        this.name = name;
        this.coins = 0;
        this.accessories = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public int getCoins() {
        return coins;
    }


    public List<String> getAccessories() {
        return accessories;
    }

    // Metod för att lägga till coins
    public void addCoins(int amount) {
        this.coins += amount;
    }


    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }


    public void earnCoinsFromStudy(int minutes) {
        int earnedCoins = minutes * 1;
        addCoins(earnedCoins);
    }


    @Override
    public String toString() {
        return "Karaktär: " + name + ", Coins: " + coins + ", Accessoarer: " + accessories; 
    }
}