# CS3343 Group 23

Mahjong Legend - Single Player Mahjong Game

Description
-----------------------------------------------------------------------------------------------------
### Background

Mahjong Legend is a single-player mahjong game based on the rules of Hong Kong Mahjong. The software simulates the mahjong game and allows the user to play with our AI. This program is especially design
for the newbie and beginners.

### Run

quick start:
Windows: double click the run.bat to start a gui game which plays four rounds of game.
Mac/Linux: open the terminal and change directory to the folder you extracted. Type the command

```
 ./run.sh
```

to quickly start a gui game which plays four rounds of game.

Expert Users:
use command line argument to control the game ui mode and the number of rounds
The `-ui` option can be used to set ui, it has GUI or TEXT two user options, the AI option is for developing tests only. 

The `-num` option is used to set the number of rounds, it receives one >0 integer value as input.
The example is as follows:

```
java -jar mahjongLegend.jar -ui GUI -num 4
```

### How to play

After entering the game, users can click the "Game Start" button to start the game. 
At Gaming Screen, the user can click the tile to discard or click the action button at the top left of the tile hand position.
After all of the tiles are drawn, the game will be over, or any players call "win action". The score result for all of players will be shown.
Users can start playing again by waiting 10 seconds.

### Rule of the game

Please refer to the User Manual.

Installation
------------------------------------------------------------------------------------------------------
1. In Windows environment, install Java SE/Java SE Development Kit (JDK)
   http://www.oracle.com/technetwork/java/javase/downloads/index.html
   This software requires Java SE Runtime Environment 15 (JRE 15). Old versions of JRE are not tested and are not guaranteed to support.
2. Execute the .bat (if you are using window) inside the build folder
   For Mac OSX, open a terminal and execute .sh
3. The program is now running in GUI
4. To run the program, you can simply open .jar file.

Release
-------------------------------------------------------------------------------------------------------
Release 2 - Release GUI version

Release 1 - Release CMD version

## Credit

ZHOU Yukun @Anyethan  Project Manager

YAO Shenglong         Assistant Project Manager

WANG Yucheng          Developer

TAM Kam Chuen         Developer

CHAN Hiu Leong        Developer

QI Xintong            Developer 
