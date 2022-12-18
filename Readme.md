#Purpose of this system.
It will calculate the ranking table for a league.

#Technical Notes
It uses the following technologies:
1. Java 8. 
2. JUnit 5.8.2
3. Maven

#Flow of the system
First you will see a menu like this: 
***************************************
Please select an option: 
1.- Load the inputs from a file.
2.- Type the inputs.
***************************************
Then:
2. You should select an option:(Input only accepts numbers)
3. If you select the source from a file, you should pass the whole path of the file.
4. If you select the source by inputs, it will ask you to enter the number of the matches that you want to rank (This input only accepts number)
5. Then, you should enter the same number of records that you entered in step 4 (example: if you entered 5 matches, you should enter 5 records of matches) 
6. After you do all the steps above, you will see the final ranking table ordered.
 
#Input/Output
The input and output will be text. Either using stdin/stdout or taking filenames on the command
line is fine.

Format of the input: (<String> <number>, <String> <number>)

Sample input:
Lions 3, Snakes 3
Tarantulas 1, FC Awesome 0
Lions 1, FC Awesome 1
Tarantulas 3, Snakes 1
Lions 4, Grouches 0

Expected output:
1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts

#Rules:

In this league, a draw (tie) is worth 1 point, and a win is worth 3 points. A loss is worth 0 points.
If two or more teams have the same number of points, they should have the same rank and be
printed in alphabetical order.
