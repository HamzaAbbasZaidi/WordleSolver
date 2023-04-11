import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class duoSolver {

    public static int offset = 97;

    public static int[] columns = {1,0,0,0,4,0,2,1,2,-1,-1,3,3,3,1,4,-1,2,3,4,1,-1,2,-1,4,-1};

    public static HashSet<Character> guessedLetters = new HashSet<>();

    public static char[] guesses = new char[] {
            'd', 'u', 'r', 's', 't',
            'b', 'o', 'g', 'l', 'e',
            'c', 'h', 'i', 'm', 'p',
            'f', 'a', 'w', 'n', 'y'
    };

    static {

        for(char guess : guesses) guessedLetters.add(guess);

    }

    public static void main(String[] args) throws IOException {

        List<String> candidates = List.of(wordlist.solutions.clone());

        System.out.println("Type out the coloured letters in the following manner: (yellows),(greens):");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] yellowGreen = input.split(",");

        String yellowLetters = yellowGreen[0];
        String greenLetters = input.charAt(input.length()-1) == ',' ? "" : yellowGreen[1];

        HashSet<Character> processedLetters = new HashSet<>();

        for (int i = 0; i < yellowLetters.length(); i++) {
            candidates = (filter(candidates, 0, yellowLetters.charAt(i)));
            processedLetters.add(yellowLetters.charAt(i));
        }

        for (int i = 0; i < greenLetters.length(); i++) {
            candidates = (filter(candidates, 1, greenLetters.charAt(i)));
            processedLetters.add(greenLetters.charAt(i));
        }

        guessedLetters.removeAll(processedLetters);

        for (char remainingLetter : guessedLetters) {
            candidates = (filter(candidates, -1, remainingLetter));
        }

    System.out.println(candidates.toString());

    }

    public static List<String> filter(List<String> startingList, int positionKnown, char letter) {

        if (positionKnown == 0) {
            return startingList.stream().filter(a -> a.indexOf(letter) != -1 && a.charAt(columns[letter-offset]) != letter).collect(Collectors.toList());
        }

        else if (positionKnown == 1) {
            return startingList.stream().filter(a -> a.charAt(columns[letter-offset]) == letter).collect(Collectors.toList());
        }

        return startingList.stream().filter(a -> a.indexOf(letter) == -1).collect(Collectors.toList());

    }
}
