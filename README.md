# AHOME
## Context:
It’s as part of a school project (in duo) of 2nd year of engineering school that we started programming an horror, action and survival game in a text version in the terminal. We were also inspired by the gameplay of the horror game Dead by Daylight.

## Gameplay:
The goal is to repair 3 generators to escape the place and a killer who is looking for you. You can also collect items such as a medical kit or a toolbox to give you an advantage in your game. Be careful, if the killer finds you, you will have to be fast to escape. 

### Commands:
In this section, all the commands you need to know to play :
- `help` : show all commands available,
- `quit` : quit the game,
- `reparer` : repair a generator,
- `prendre` : take a medkit or a toolbox on the floor,
- `heal` : use a medkit to heal yourself,
- `outil` : use a toolbox to repair instantly the generator,
- `go` + `haut` or `bas` or `droite` or `gauche` or `up`or `down` : move in the direction indicated.

<p align="center">
  <img width="720" alt="AHOME_Commands" src="assets/AHOME_Commands.png">
</p>

> Words partially written or with small misspellings will be understood by the game. Capital letters are not taken into account.

## Features:
- Two difficulty modes are available and result in different maps and faster skill tests,
- Map and information are displayed in the terminal and the player represented by a star,
- Player has two lives,
- To win you need to repair 3 generators and exit from the exit room,
- A generator is repaired in several times unless you have a tool box (it's instant),
- Recoverable items are for single use and only one can be taken at a time,
- By using the medkit, you earn a life,
- If you are in the same room as the killer, a skill test starts (calculation or writing a letter). If you succeed, you dodge the hit else you lose a life,
- The presence of a generator or object in a room is indicated next to the room name in brackets.

> Some values such as the number of lives, skill tests, the number of items, of generators can be modified in the "customPreset.txt" file. Don't modify the values in "defaultPreset.txt" file.

> Your statistics are also available in "saveData.txt" file. You can delete the old one (his creation is automatic).
  
<p align="center">
  <img width="720" alt="AHOME_Gameplay" src="assets/AHOME_Gameplay.png">
</p>

## Available:
If you want to play and test this game, you just need to download "AHOME The Game" in ralease section. Then to launch it, open the run.bat file. The game can be played on all devices which have java and a terminal or command guest. 

> An English version may appear.

## State:
- [ ] Work in progress
- [x] Work completed
