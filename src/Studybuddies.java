

public class Studybuddies {
                public static void main(String[] args) {
                        while (true) {
                                // Skapa en instans av Connect som hanterar inloggning och karaktärsskapande
                                Connect connect = new Connect();


                                // Starta spelet
                                connect.startGame();

                                // När användaren väljer att avsluta spelet, loopar vi tillbaka till inloggningssidan
                                System.out.println("\nÅtervänder till inloggningssidan...");
                        }
                }
        }
