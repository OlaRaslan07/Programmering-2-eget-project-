

import java.util.*;

public class Character {
    public DataBase.UserData userData;
    public DataBase dataBase;

    public Character(DataBase.UserData userData, DataBase dataBase) {
        this.userData = userData;
        this.dataBase = dataBase;
    }

    public String getName() {
        return userData.characterName;
    }

    public int getCoins() {
        return userData.coins;
    }

    public List<String> getAccessories() {
        return userData.accessories;
    }

    public void addCoins(int amount) {
        userData.coins += amount;
        dataBase.updateUserData(userData);
    }

    public void addAccessory(String accessory) {
        if (!userData.accessories.contains(accessory)) {
            userData.accessories.add(accessory);
            dataBase.updateUserData(userData);
        }
    }

    public void earnCoinsFromStudy(int minutes) {
        int earnedCoins = minutes * 30;
        addCoins(earnedCoins);
    }

    @Override
    public String toString() {
        return "Karaktär: " + getName() + ", Coins: " + getCoins() + ", Accessoarer: " + getAccessories();
    }
}
