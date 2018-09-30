Credit Card

Along with credit card number and the boolean isValid, I also created instance 
variables and initialized some digits necessary for multiple checks. Then, I
made a seperate check method for each of the rules: check1 for 4 as the first
digit, check2 for the fourth digit being greater than the fifth digit by 1,
check3 for the product of the first, fifth and ninth digit being 24, check4 
for the sum of all digits being divisible by 4, check5 for sum of first four
digits being equal to the sum of last four digits minus 1, and check6 for the
number made by the first and second digit plus the number made by the seventh 
and eight digit equaling 100.

Each check method was placed in a general check method. Also, in each check 
method, I applied a conditional statement for the error code; if the error code
is 0, meaning number is valid, then do the next check. If a method turns the 
error code into its check number, the method for checking all the other checks 
would stop and return the boolean isValid or not and the error code for the
first rule broken.


Game of Nim

In Human.java, I made a chooseComputerMode method for the user to first input 
what computer mode they would like to play against, 0 (stupid) or 1 (smart). I 
assume benevolent user here, one who will only input 0 or 1. The move method 
takes the next user input as how many marbles they'd like to take.

In Computer.java, I made a move method that differed with a conditional
statement depending on what mode it was in. If the mode was 0 (stupid), it
would take a random amount of marbles between 1 and the total marbles divided by
2 from the pile. Otherwise, the mode was 1 (smart). In this mode, if there were 
3, 7, 15, 31, or 63 marbles left, the computer would take a random number of 
marbles, from 1 to the total marbles divided by 2, from the pile. Otherwise, the
computer would remove as many marbles until the total marbles left reaches the 
closest and legal value of one of the above numbers (a power of 2 minus 1). 
I made a seperate case for when 2 marbles are left, in which case the computer 
would take 1 marble away always.

In Game.java, I combined everything together. First, I initialized a new human
object. Then, in computerMode method, I called the human class to choose 0 or 1
for computer mode and initialized a new computer object depending on which mode 
it is playing as. Then, in setFirstMove, who goes first is randonly assigned. In
playHuman method, I called the human class move method and if the user inputs a
legal value (between 1 and total marbles divided by 2) then the human's choice
would be subtracted from the marbles variable and humanTurn changes to false so
the computer can go next. Otherwise, the method calls for the user input again 
until it's a legal move. In the playComp method, I call the computer class move 
method as well which will follow the instructions set in that method depending 
on what mode its in. The playComp method will then subtract the computer's 
choice from the variable marbles as well and humanTurn will be reset to true. 

Combined together, the play method then first sets the computer mode, then sets 
first move, then creates a pile of marbles of a random number between 10 and
100, then applies the boolean initialized in setFirst move to make the human
play or the computer play first. After each turn, the boolean is flipped so the 
other player can go as long as marbles is greater than 1. If the marbles left 
equals 1 during the computer's turn (humanTurn would be false), the human wins,
otherwise, if the marbles left equals 1 and it's the human's turn, the computer
wins!

Finally, the test class Nim.java calls the play method in the game class to
actually put everything into play.
