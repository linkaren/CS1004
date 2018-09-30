Array Methods

Kind of self-explanatory + comments in the code!

Poker Game

In Card.java, I first created a card object with explicit variables of rank and
suit that will be used in arrays for the deck and player's hand later. The
compareTo method satisfies the implement Comparable<Card> header as it allows
for future cards to be compared with each other by rank and, if equal, by suit.
I then made methods that would allow me to more easily see if card ranks and
suits were equal, later called in my hand methods. The final methods of this
class are accessor methods for card object, rank and suit.

In Deck.java, I made a deck array of 52 card objects for every rank and suit
combination. Then, I made a shuffle method that would pick two random cards in
the deck and swap their places 200 times. The deal method deals the the card
object at the index set by top which starts at 0 and increases by one every
time the method is called in the game. when top passes 51, the end of the deck,
the deck is reshuffled and top is reset to 0 making an infinite deck.

In Player.java, I created a player that can holds an arraylist of cards. The
following methods manipulate the player's hand when called upon: addCard adds a
card object to the array list, replace (used instead of removeCard for redraw in
the game) replaces the card object at the specified index with a different card 
object, and clearHand clears the player's hand of all card objects. The accessor
methods getHand just returns the player's hand while getBankroll returns the
bankroll. Finally, bets keeps track of user inputed amount which will be 
subtracted from bankroll while winnings takes the bet, multiplies it by the
hand's respecitve payout, and adds that to the existing bankroll

Finally, in Game.java, one constructor, which takes in an argument, creates a 
poker game with a testerHand while the other contructor with no explicit
argument creates a poker game in which a user can play. For the tester, it take
in a string array and evaluates the character at index 0 for each string element
for c, d, h, or s signifying its respective suit. The rest of each string
element is taken in as an integer signifying its rank. Thus for each element, a
new card object is created and put into the player's hand. Then in the play
method, if getTester is true, the new hand with go through the checkHand method 
which will be explained later.

For the actual poker game, a new player and deck are created and if getTester is
not true, a poker game is initiated. After showing the starting bankroll, setting
player wanting to continue as yes, and shuffling the deck, the player can bet her
tokens. After that, five cards are dealt and added to the player's hand. The
redraw method is called which asks the player if it wants to replace each card 
and does so when the answer is yes. Now, the checkHand method is called as well
(explained later) and winnings are adjusted and hand is cleared. If the player 
has no more tokens in their bankroll, the game ends, if the player doesn't want 
to continue the game anymore, the game ends as well, otherwise the game repeats.

For checkHand method, I set highestHand to 0 and created and called individual 
methods to check for royal flush (same suit with ace, 10, jack, queen, king), 
straight flush (same suit, 5 cards of consecutive ranks), four of a kind (4 cards
of equal ranks), full house (three cards of equal rank, 2 different cards of 
different equal ranks), flush (same suit), straight (5 cards of consecutive 
ranks), three of a kind (3 cards of equal ranks), two pairs (2 cards of equal 
ranks, 2 different cards of different equal ranks), one pair (2 cards of equal 
ranks) and no pair (all different ranks, not all same suit). If a hand matches the
requirements of an individual check, highestHand is changed to a unique number, 
and any following methods are not performed. Then, the correct hand result is
printed and the respective payout is set according to the highestHand number! This
is used in both constructors to evaluate the player's hand. 
