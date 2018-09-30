Dictionary

In my WordLists.java class, I first created a new private RandomAccessFile for
the dictionary. Then, I created methods for each of the searches: each was 
similar in that all for created a new arrayList for the selected words to 
be copied into and added words that followed the respective rules to it as the
file was read. Furthermore, each had their file pointer, or index, reset back
to 0 at the end of the method in order to avoid creating new scanners for each
method, and then each returned its arraylist. More specifically, lengthN added 
words whose length matched n to its method localized arraylist, startsWith 
went further to make sure the first character matched firstLetter as well, 
containsLetter made sure that a character other than the first matched included
instead, and finally multiLetter added words to its respective arrayList which
had characters matching included exactly m times as given. Each method also
throws an IO exception due to containing and/or mutating a RandomAccessFile
object.

In my tester class, I created a new WordLists object then a new PrintWriter for
each method and a string for each resulting arrayList as well. Each would print
out the resulting array into a new text file, ending up with four text files
with words that follow each respective method's rules. Finally, the exception 
thrown in WordLists.java is caught here (IO exception) resulting in an printed
error if exception occurs. 
