# Study Hero
## User Specification
The program is a productivity timer with an adventure game aspect, letting a user designate durations for their work and break sessions (e.g., Pomodoro). After the user has completed the work timer, they obtain loot and upgrades that make the user’s character stronger, getting more loot the longer they have studied (if the user does not finish their session, they will receive less loot). Once the user starts their break session, they have a menu they can access for going to the shop and buying equipment, fighting bosses, changing equipment, or going back to studying.

The character should have stats the user can access that see how strong they are and what equipment they have. These stats determine their ability to defeat bosses. The user should be able to change the timer settings to match how much time they want to study and save their progress if they want to keep how long they’ve studied for using the program.

## Features
- Timer: Start, pause, or end the timer early. After the timer is complete, the user can click a button to go to the break menu. The user can select from three different preset timer durations or set their own duration.
- Inventory: Have access to different types of items, including equippable items and consumables, that the user can equip or use.
- Stats: Stats that the user has and can level up as they continue to study and progress with the bosses. This also includes things like the user's gold and the stats for the Boss that the user can fight during their breaks.
- Dialogue: A series of dialogue options that the user can see during their breaks, study times, boss fights, etc.
- Break Menu: A place where the user can see different options after completing the study timer. This includes seeing their inventory and stats, going to the shop, or going to fight the boss or to go back to study.
- Settings: Where the user can save or load their saves, or quit the game. There is also the ability to pause the music in the settings menu.
- Shop Menu: The user can buy or sell their items that the user needs to fight the Bosses for or to get rid of unnecessary items in their inventory.
- Saving/Loading Data: The user can save their data for when the user wants to close the program, and can load their data again when the user runs the program again to study.
- Start Menu: Where the user starts the game: they can choose to load a save, or to start a new game.
- Boss Fights: The user can fight bosses during their breaks, which goes into a Rock/Paper/Scissors-type gamemode. If the user completes the boss fight successfully, then their stats are affected and the user "progresses" in the game.

**For more info on gameplay, check out [our wiki](https://github.com/CSC207-2022F-UofT/course-project-studyhero/wiki)!**

## Running the Code
The program can be run from the class GameMain.java.

## Design
See our [Design Wiki](https://github.com/CSC207-2022F-UofT/course-project-studyhero/wiki/Design) for info on our major design decisions (Clean Architecture, SOLID, packaging etc.).

## Test Coverage
(include coverage reports + explanations of what hasn't been tested here)

## Issues
- The Shop Menu did not manage to have complete implementations for the Sell Menu screen, so it was omitted from the final project.

- The Dialogue system did not manage to be completed on time, so some parts of the dialogue and cutscenes were not included in the final project when committing to our main branch.

