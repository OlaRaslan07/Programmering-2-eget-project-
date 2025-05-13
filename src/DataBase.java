import java.io.*;
import java.util.*;

public class DataBase {

    public static final String DATA_FILE = "user_data.dat";

    Map<String, UserData> usersData;

    public DataBase() {
        usersData = new HashMap<>();
        loadData();
    }

    public static class UserData implements Serializable {
        public static final long serialVersionUID = 1L;

        public String username;
        public String characterName;
        public int coins;
        public String password;
        public List<String> accessories;

        public UserData(String username, String password, String characterName, int coins) {
            this.username = username;
            this.password = password;
            this.characterName = characterName;
            this.coins = coins;
            this.accessories = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return; // No data yet
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                usersData = (Map<String, UserData>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load user data: " + e.getMessage());
        }
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(usersData);
        } catch (IOException e) {
            System.out.println("Failed to save user data: " + e.getMessage());
        }
    }


    public boolean registerUser(String username, String password, String characterName) {
        if (usersData.containsKey(username)) {
            return false; // Already exists
        }
        usersData.put(username, new UserData(username, password, characterName, 0));
        saveData();
        return true;
    }

    public UserData validateUser(String username, String password) {
        UserData data = usersData.get(username);
        if (data != null && data.password.equals(password)) {
            return data;
        }
        return null;
    }


    public void updateUserData(UserData userData) {
        usersData.put(userData.username, userData);
        saveData();
    }
}
