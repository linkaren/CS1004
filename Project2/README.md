# CS1004

Leap Year

I first declared and initialized givenYear as a user input variable. After, I 
set up my boolean isLeapYear method - if the given year is divisible by 100 and
not by 400, it isn't a leap year. If the year is divisible by 4 and/or 400, it
is a leap year. Any other year input would also not be a leap year.

Drunkard

I first declared instance variables for the initial avenue and street, which
wouldn't change throughout the algorithm, and a current avenue and street, 
which would change as the drunkard moves from intersection to intersection. 
After initializng them, I set up a random number generator in thr step method
for the direction the drunkard would move (north, east, south, west) and moved 
the drunkard 1 block in the decided direction.
Through the fastForward method, I just called the step method above for each 
intersection he comes across. Finally, I returned the values for the final 
avenue and street location and the distance from his starting location.
