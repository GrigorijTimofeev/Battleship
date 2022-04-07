# Battleship
Simple 2 players console battleship game on Java

Errors handling 

### Filling table with ships one at a time

    Player 1, place your ships to the game field

      1 2 3 4 5 6 7 8 9 10 
    A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

    Enter the coordinates of the Aircraft Carrier(5 cells):
    
    > B2 F2
    
### Shooting enemies ships 

    The game starts!

      1 2 3 4 5 6 7 8 9 10 
    A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    ---------------------
      1 2 3 4 5 6 7 8 9 10 
    A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    B ~ O ~ ~ ~ ~ ~ ~ ~ ~ 
    C ~ O ~ O ~ ~ ~ ~ ~ ~ 
    D ~ O ~ O ~ O ~ O ~ ~ 
    E ~ O ~ O ~ O ~ O ~ ~ 
    F ~ O ~ O ~ O ~ O ~ ~ 
    G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    I ~ ~ ~ ~ ~ O O ~ ~ ~ 
    J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

    Player 1, it's your turn:
    
    > C2
    
    ...

          1 2 3 4 5 6 7 8 9 10 
    A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    B ~ X ~ ~ ~ ~ ~ ~ ~ ~ 
    C ~ X ~ ~ ~ ~ ~ ~ ~ ~ 
    D ~ X ~ ~ ~ ~ ~ ~ ~ ~ 
    E ~ X ~ ~ ~ ~ ~ ~ ~ ~ 
    F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    ---------------------
      1 2 3 4 5 6 7 8 9 10 
    A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    B ~ O ~ ~ ~ ~ ~ ~ ~ ~ 
    C ~ X ~ O ~ ~ ~ ~ ~ ~ 
    D ~ X ~ O ~ O ~ O ~ ~ 
    E ~ X ~ O ~ O ~ O ~ ~ 
    F ~ X ~ O ~ O ~ O ~ ~ 
    G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 
    I ~ ~ ~ ~ ~ O O ~ ~ ~ 
    J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 

    Player 1, it's your turn:

    > F2

    You sank a ship!
    Press Enter and pass the move to another player
