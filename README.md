## Duotrigordle Practice Tool

This is a Wordle-style solver specifically designed for Duotrigordle (before the word list changed 😔). It uses a fixed set of four guess words - 'durst', 'bogle', 'chimp', and 'fawny'. These words were chosen because the combination of colors (green, yellow, gray) they produce on any Duotrigordle word is almost always unique.

### How it works

For each word you're trying to solve, simply input the results of the guesses as a sequence of digits:
- '2' for green (correct letter, correct spot)  
- '1' for yellow (correct letter, wrong spot)  
- '0' for gray (letter not in the word)

The program takes these four 5-digit codes (one per guess word) and instantly tells you which solution word it corresponds to.

### Why I made this

I built this as a practice tool to help me learn and recognize common patterns in Duotrigordle. By understanding how certain words react to these four guesses, you can start being able to deduce what word it is pretty quickly.
