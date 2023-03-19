# Poker
The Poker service can evaluate whether a set of 7 cards is a straight hand.

Each card has a value from 1 to 13

1 - Ace  
11 - Jack  
12 - Queen   
13 - King

Each card has a type  
Valid types are CLUBS, DIAMONDS, HEARTS, SPADES.  

## Straight hand
7 cards    
5 of which be sequential values     
1,2,3,4,5 are sequential  
10,11,12,13,1 are sequential  
10,11,12,13,2 are not sequential  

### Building

./gradlew clean build

### Running the service

java -jar build/libs/poker-0.0.1-SNAPSHOT.jar

or

./gradlew bootRun

### Usage or Calling the service

You can use any http client. Below are some examples using curl

curl -X POST -H 'Content-Type: application/json' -d '[{"value":1, "type": "CLUBS"}]' http://localhost:8080/poker/isstraight

Response is false

curl -X POST -H 'Content-Type: application/json' -d '[{"value":1, "type": "CLUBS"},{"value":3, "type": "DIAMONDS"},{"value":5, "type": "HEARTS"},{"value":7, "type": "SPADES"},{"value":6, "type": "CLUBS"},{"value":4, "type": "HEARTS"},{"value":1, "type": "DIAMONDS"}]' http://localhost:8080/poker/isstraight

Response is true

### TODO

Return better and meaningful error responses.  
Duplicate card in input should be marked invalid input and return false
