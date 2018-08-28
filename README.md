#Pawn's tour

##Overview

This is a variation of the  [Knight's tour](https://en.wikipedia.org/wiki/Knight%27s_tour) problem applied to a Pawn following this rules:

A pawn can move on 10x10 chequerboard horizontally, vertically and diagonally by these rules:

 1) 3 tiles moving North (N), West (W), South (S) and East (E)
 2) 2 tiles moving NE, SE, SW and NW
 3) Moves are only allowed if the ending tile exists on the board
 4) Starting from initial position, the pawn can visit each cell only once

This solution was developed using Scala and it exposes an Http service with one endpoint to get the path found.


## Approach 

Basically, [Pawn.findPath](https://github.com/simonmontanez/pawn-tour/blob/develop/src/main/scala/pawntour/domain/Pawn.scala#L18) 
builds a list with the steps to visit all the tiles. It's a tail recursive function that calculates the possibles next moves 
sorted by an [initial order] of coordinates and [the number of possibles] next steps. If someone valid move is found then the state will be updated, 
if not and is not all the possibles are done (100) the searching will start again but with a different [coordinates order] 



