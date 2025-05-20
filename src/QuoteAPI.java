import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class QuoteAPI {
    private static final String ZEN_QUOTES_API_URL = "https://zenquotes.io/api/random";

    /**
     * Fetches a random inspirational quote from the Zen Quotes API
     * @return A formatted string containing the quote and its author
     */
    public String getRandomQuote() {
        try {
            // Create URL and open connection
            URL url = new URL(ZEN_QUOTES_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the request was successful
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response (simplified parsing)
                String jsonResponse = response.toString();

                // Extract quote and author from the response
                // Format: [{"q":"Quote text","a":"Author name","h":"<html>"}]
                String quote = extractValue(jsonResponse, "q");
                String author = extractValue(jsonResponse, "a");

                return "\"" + quote + "\" - " + author;
            } else {
                // If API call fails, return a default quote
                return getDefaultQuote();
            }
        } catch (IOException e) {
            System.out.println("Error connecting to Zen Quotes API: " + e.getMessage());
            return getDefaultQuote();
        }
    }

    /**
     * Simple method to extract values from JSON response
     */
    private String extractValue(String json, String key) {
        String searchKey = "\"" + key + "\":\"";
        int startIndex = json.indexOf(searchKey) + searchKey.length();
        int endIndex = json.indexOf("\"", startIndex);
        if (startIndex >= searchKey.length() && endIndex > startIndex) {
            return json.substring(startIndex, endIndex);
        }
        return "";
    }

    /**
     * Returns a default quote in case the API call fails
     */
    private String getDefaultQuote() {
        String[] defaultQuotes = {
                "\"The only way to do great work is to love what you do.\" - Steve Jobs",
                "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill",
                "\"Education is the most powerful weapon which you can use to change the world.\" - Nelson Mandela",
                "\"The future belongs to those who believe in the beauty of their dreams.\" - Eleanor Roosevelt",
                "\"The best way to predict the future is to create it.\" - Peter Drucker"
        };

        Random random = new Random();
        return defaultQuotes[random.nextInt(defaultQuotes.length)];
    }
}

