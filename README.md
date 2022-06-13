# ZombieWar
ZombieWar Project: 
Group 1 (Kevin Nguyen, Lisa Ahnell, North Seelinger)
CSC 422: Software Engineering
Summer 2022

Zombie War simulation, used to practice object modeling. 

This application organizes teams of human combatants and zombie combatants into teams whose members attack each other in turn, continuing until one side is depleted of combatants. The details of the combat are displayed on the screen, and a summary is posted at the conclusion. Upon starting the game, the user may choose to start the game, view a description or exit, these choices continue after each selection is complete until the user decides to exit.

Classes:

Combatant
All combatants have common behaviors, and are underpinned by the abstract Combatant class, which is extened by subclasses Newbie, Soldier, Mercenary, Common and Tank. The subtypes are differentiated by their attack and health values. Additionally, the human and zombie types have specific methods for assigning nicknames and battle quotes.

Group
Combatants are organized into Groups, consisting of either zombie types or human types, which will fight against eachother until one side is defeated. If a member of a group is killed, they are moved to a separate collection of dead combatants. 

BattleManager
The BattleManager class runs the combat between the two groups. Combat consists of turns, where all members of one side make an attack, and then all memebers of the other side take a turn attacking. The BattleManager continues the simulation until one side is depleted of combatants.

ZombieWar
Controlling the whole process, and linking it to the user control is the ZombieWar class. From here, the user is able to control the game through selecting options from a menu.
