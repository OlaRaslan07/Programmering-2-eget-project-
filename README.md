# StudyBuddies

StudyBuddies is a gamified study timer application that helps users track their study time while earning virtual coins and customizing their character. The application encourages productive study habits by rewarding users for their study sessions.

## Features

- **User Authentication System**: Register and login to save your progress
- **Character Customization**: Create and personalize your study buddy character
- **Study Timer**: Track your study sessions with a countdown timer
- **Reward System**: Earn coins based on your study time
- **Upgrade Shop**: Spend your earned coins on accessories for your character
- **Progress Persistence**: All your data is saved between sessions

## Project Structure

- `Studybuddies.java`: Main application entry point
- `Connect.java`: Handles connections between different components
- `loginSystem.java`: Manages user registration and authentication
- `DataBase.java`: Handles data persistence for user information
- `Character.java`: Manages character properties and accessories
- `Player.java`: Tracks user study statistics
- `Clock.java`: Implements the study timer functionality
- `Upgrades.java`: Manages the shop system for character accessories

## How It Works

1. Users register or login to access their account
2. After authentication, users can:
   - Start study sessions with a countdown timer
   - Earn coins based on study time (30 coins per minute)
   - Visit the shop to purchase accessories for their character
3. All progress is automatically saved to a local data file

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Running the Application

1. Clone this repository:
   ```
   git clone https://github.com/yourusername/Programmering-2-eget-project-.git
   cd Programmering-2-eget-project-
   ```

2. Compile the Java files:
   ```
   javac -d out src/*.java
   ```

3. Run the application:
   ```
   java -cp out Studybuddies
   ```

### Usage Instructions

1. When you first run the application, you'll be prompted to register or login
2. After logging in, you can:
   - Select option 1 to start a study session
   - Select option 2 to visit the upgrade shop
   - Select option 3 to exit the application

## Data Storage

User data is stored in a file called `user_data.dat` in the application directory. This includes:
- Username and password
- Character name
- Coin balance
- Purchased accessories

## Future Enhancements

- Daily study goals and streaks
- More character customization options
- Study statistics and analytics
- Multiplayer/social features

## License

This project is created as part of a programming course and is available for educational purposes.
