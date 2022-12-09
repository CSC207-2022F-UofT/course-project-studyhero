# Study Hero
## User Specification
The program is a productivity timer with an adventure game aspect, letting a user designate durations for their work and break sessions (e.g., Pomodoro). After the user has completed the work timer, they obtain loot and upgrades that make the user’s character stronger, getting more loot the longer they have studied (if the user does not finish their session, they will receive less loot). Once the user starts their break session, they have a menu they can access for going to the shop and buying equipment, fighting bosses, changing equipment, or going back to studying.

The character should have stats the user can access that see how strong they are and what equipment they have. These stats determine their ability to defeat bosses. The user should be able to change the timer settings to match how much time they want to study and save their progress if they want to keep how long they’ve studied for using the program.

## Features
- Timer: Start, pause, or early end a timer. After the timer is complete, it should go to the break menu. There is also the ability to change the timer duration to be different from the default 25 minutes.
- Inventory: Have access to different types of items, including equippable items and consumables, that the user can equip or use.
- Stats: Stats that the user has and can level up as they continue to study and progress with the bosses. This also includes things like the user's gold and the stats for the Boss that the user can fight during their breaks.
- Dialogue: A series of dialogue options that the user can see during their breaks, study times, boss fights, etc.
- Break Menu: A place where the user can see different options after completing the study timer. This includes seeing their inventory and stats, going to the shop, or going to fight the boss or to go back to study.
- Settings: Where the user can save or load their saves, or quit the game. There is also the ability to pause the music in the settings menu.
- Shop Menu: The user can buy or sell their items that the user needs to fight the Bosses for or to get rid of unnecessary items in their inventory.
- Saving/Loading Data: The user can save their data for when the user wants to close the program, and can load their data again when the user runs the program again to study.
- Start Menu: Where the user starts the game: they can choose to load a save, or to start a new game.
- Boss Fights: The user can fight bosses during their breaks, which goes into a Rock/Paper/Scissors-type gamemode. If the user completes the boss fight successfully, then their stats are affected and the user "progresses" in the game.

## Running the Code
~~The program can not currently be run as an executable. However, for testing purposes, there are two parts of the program that are currently runnable:~~ <br/>
~~1. The Timer Menu - The UI is available to look at, however, the Timer itself is not currently working (see Issues).~~ \n
~~2. The Menus with skeletons for the Shop Menu, Break Menu, and Main Menu screens.~~ \n

~~Both features can be run by clicking "Run" on the "main" functions in TimerScreen.java for the Timer Menu, and mainPanel.java for the Main Menus.~~

The program can be run from the class GameMain.java (this does not exist in the main branch yet, check GUI branch to find it. TODO: merge branches to main so the game can be played from there.)

## Issues
Some of the features of the program are not yet complete due to the core mechanics of the game (i.e., stats, timer, inventory, save data, GUI). Since our program is turning out to be a lot more ambitious than anticipated, some of these features took longer than expected, and thus delaying the implementation of some of our other features as well. Namely:

- The Settings Menu relies heavily on the GUI and Save Data in order to function. Additionally, the Pause Music feature we wanted to implement has still not been added, as the music is more of a quality of life feature we are hoping to add in the final product. It is possible that this music feature may not be implemented in the end in favour of time.

- The Shop Menu uses the Inventory and Stats Menu, and is also heavily dependent on the GUI in order to run. Because of how we wanted to set up the Buy and Sell menus, it is difficult to implement concrete features using dummy values and instead requires the different classes from the Inventory and Stats in order to assure that the feature is able to work correctly. The Shop Menu will definitely finish implementation by the end of the final deadline now that the implementations for Stats and Inventory are almost fully complete.

- The Boss Fight Menu relies on the Stats and Inventory Menu in order to function, since the Boss and Player has different stats that needed to be accounted for in the combat. Similar to the Shop Menu, since the implementations for the two features are almost complete, once the final commits and merges are made, then the feature can be fully completed.

- The Timer is also currently having issues between the interactor and the controller and thus the Start Timer button does not work. However, all other implementations of the feature have been tested and seem to function correctly, so once the bug has been fixed the Timer will be fully completed.

However, since most of the implementations for the dependencies are now completed for the most part, these features can definitely be implemented by the final deadline for the project.

There are also issues with naming conventions, especially with packages, however, this will be fixed by the time the program is finally handed in.

## Test Coverage
(include coverage reports + explanations of what hasn't been tested here)
