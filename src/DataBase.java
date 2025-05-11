import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private static final String DATA_FILE = "user_data.dat";

    // Stored as username -> UserData object
    private Map<String, UserData> usersData;

    public DataBase() {
        usersData = new HashMap<>();
        loadData();
    }

    // Inner class to hold user data
    public static class UserData implements Serializable {
        private static final long serialVersionUID = 1L;

        public String username;
        public String characterName;
        public int coins;
        public String password;

        public UserData(String username, String password, String characterName, int coins) {
            this.username = username;
            this.password = password;
            this.characterName = characterName;
            this.coins = coins;
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    private void loadData() {
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

    // Save data to file
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(usersData);
        } catch (IOException e) {
            System.out.println("Failed to save user data: " + e.getMessage());
        }
    }

    // Register new user data
    public boolean registerUser(String username, String password, String characterName) {
        if (usersData.containsKey(username)) {
            return false; // Already exists
        }
        usersData.put(username, new UserData(username, password, characterName, 0));
        saveData();
        return true;
    }

    // Validate user credentials and return user data or null if invalid
    public UserData validateUser(String username, String password) {
        UserData data = usersData.get(username);
        if (data != null && data.password.equals(password)) {
            return data;
        }
        return null;
    }

    // Update user data e.g. coins, character name
    public void updateUserData(UserData userData) {
        usersData.put(userData.username, userData);
        saveData();
    }
}
