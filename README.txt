Joseph Richard Adam Malam
SYNALOGiK Java Programming Test
Thursday 10th March 2022

Compile and run the Task.java class, which takes a single argument — the text file path (e.g. sample.txt").

I have written three unit tests:
  1. Test the example text provided on the instruction sheet.
  2. Test for correct interpretation of word if spaces are missing between punctuation.
  3. Test for correct output if txt file is blank.

I assume that for the purposes of the task, a word is defined as:
  * any string of characters that is separated by spaces
  * any string of characters that does not contain any of the following punctuation:
    !._,@?
    These punctuation marks do not include apostrophes which can be included in single words (e.g. Joseph's)
    Ampersand & sign is not included as in the brief (presumably because this is just shorthand for "and").
    When a word contains any of these punctuation marks, the word is split.