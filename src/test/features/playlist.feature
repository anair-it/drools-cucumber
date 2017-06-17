Feature: Music Playlist scenarios

  Scenario: Find Metallica song in a 3 song playlist
    Given a playlist called 'myfav' exists
    And the following songs exist in the playlist
  | title   		| genre | artists 		| duration 	|
  | Shape of you  	| POP  	| Ed Sheeran 	| 5 		|
  | Run to the hills| ROCK 	| Iron Maiden 	| 4 		|
  | Enter sandman   | ROCK  | Metallica  	| 4			|
    When rules get fired
    Then atleast '1' rule is executed
    And response says 'Found Metallica song: Enter sandman'

  Scenario: No Metallica song in a 3 song playlist
    Given a playlist called 'myfav' exists
    And the following songs exist in the playlist
  | title   		| genre | artists 			| duration 	|
  | Shape of you  	| POP  	| Ed Sheeran 		| 5 		|
  | Run to the hills| ROCK 	| Iron Maiden 		| 4 		|
  | Billy Jean  	| POP  	| Michael Jackson  	| 4			|
    When rules get fired
    Then atleast '0' rule is executed
    And response says Not Found
