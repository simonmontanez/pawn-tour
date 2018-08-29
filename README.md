# Pawn's tour

## Overview

This is a variation of the  [Knight's tour](https://en.wikipedia.org/wiki/Knight%27s_tour) problem applied to a Pawn following this rules:

A pawn can move on 10x10 chequerboard horizontally, vertically and diagonally by these rules:

 1) 3 tiles moving North (N), West (W), South (S) and East (E)
 2) 2 tiles moving NE, SE, SW and NW
 3) Moves are only allowed if the ending tile exists on the board
 4) Starting from the initial position, the pawn can visit each cell only once

This solution was developed using Scala and it exposes an Http service with one endpoint to get the path found.


## Approach 

Basically, [Pawn.findPath](https://github.com/simonmontanez/pawn-tour/blob/develop/src/main/scala/pawntour/domain/Pawn.scala#L18) 
builds a list with the steps to visit all the tiles. It's a tail recursive function that calculates the possibles next moves 
sorted by an [initial order](https://github.com/simonmontanez/pawn-tour/blob/develop/src/main/scala/pawntour/domain/Pawn.scala#L7) of coordinates and [the number of possibles](https://github.com/simonmontanez/pawn-tour/blob/develop/src/main/scala/pawntour/domain/Pawn.scala#L52) next steps. If some valid move is found then the state will be updated, 
if not and not all the tiles are visited (100) the searching will start again but with a different [coordinates order](https://github.com/simonmontanez/pawn-tour/blob/develop/src/main/scala/pawntour/domain/Pawn.scala#L31)

## Running and Testing

### Prerequisites

1. Just install SBT:
    * [SBT for Linux](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Linux.html)
    * [SBT for Mac](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Mac.html)
    * [SBT for Windows](http://www.scala-sbt.org/0.13/docs/Installing-sbt-on-Windows.html)
    
### Starting the service

The project exposes HTTP service using the port 8080

#### Running http locally

```bash
sbt
run
```
#### Getting the Pawn's tour via HTTP endpoint

* `GET http://localhost:8080/pawn-tour?raw=0&col=0`<br />
URL Query parameters.<br />
`raw`: Raw position.<br />
`col`: Column position.<br />


The response will return a JSON list with all the Coordinates sorted in order to visit all the tiles. The timeout to find a path is 1 second.


#### Running unit test

```bash
sbt
test
```

#### Get tests coverage report

```bash
sbt
review
```








