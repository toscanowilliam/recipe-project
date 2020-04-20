package com.company.Controllers;

import com.company.Controllers.Database.getAllObjects;
import com.company.Controllers.Database.organizeData;
import com.company.Models.Recipe;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpellCheck {

    //This function will most likely not be needed any more. It maps each character with a word count. Could be useful but I don;t know
    public static void compareTheNumberOfLettersOfWord(String inputedWord) {

        //
        Map<String, Integer> letterCountsOfInputedWord = getLetterCountsOfWord(inputedWord);


        OuterLoop:
        for (Recipe recipe : getAllObjects.allCurrentRecipes()) {
            String currentNameOfRecipe = recipe.getNameOfRecipe();
            Map<String, Integer> letterCountsOfNameOfRecipe = getLetterCountsOfWord(currentNameOfRecipe);

            //I'm trying to find out how to check if there's 1 matching key (letter) in both maps.
            //Then, I'm trying to see if there is a value (letter count) greater than 1 in at least one of the maps.

            System.out.print("\n1");

            InnerLoop:
            for (Map.Entry<String, Integer> entry : letterCountsOfNameOfRecipe.entrySet()) {
                System.out.print("\n2");

                String currentLetterOfRecipe = entry.getKey();
                int currentLetterCountOfRecipe = entry.getValue();

                if (letterCountsOfInputedWord.containsKey(currentLetterOfRecipe)) //If there is a matching letter in both words
                {
                    System.out.print("\n3");

                    if (currentLetterCountOfRecipe == 2 && letterCountsOfInputedWord.get(currentLetterOfRecipe) == 2) {
                        System.out.print("\nDid you mean " + currentNameOfRecipe + "?\n");
                        break OuterLoop;
                    }
                }
            }
            System.out.print("\nRecipe not found. Please check your spelling and try again");
        }
    }

    //This is an extension of the above function. Again, might not need this anymore.
    public static Map<String, Integer> getLetterCountsOfWord(String inputedWord) {

        String word = inputedWord;

        Map<String, Integer> numberOfCharactersInWord = new HashMap<>();
//        Map<Character, Integer> numberOfCharactersInWord = new HashMap<>();


        for (int i = 0; i <= word.length(); i++) //loops through word
        {

            String characterInWord = String.valueOf(word.charAt(i)); // converts char to string
            int letterCount = word.length() - word.replaceAll(characterInWord, "").length();

            numberOfCharactersInWord.put(characterInWord, letterCount);
        }

        return numberOfCharactersInWord;
    }

    //This function below that I commented out doesn't provide that useful of information
    //...So I'm resorting to creating lists of word-fragments for each word.
//    public static int checkHowManyLettersInARowMatch(String inputedWord, String otherWord) {
//
//        //This function works but only if the letters are in matching order and the words are the same size.
//        //In other words, too many things are hard-coded here.
//
//        //      Map<String, Integer> numberOfCharactersInWord = new HashMap<>();
////        Map<Character, Integer> numberOfCharactersInWord = new HashMap<>();
//
//        int lettersInARow = 0;
//
//        int lettersInARow2 = 0;
//
//        int lettersInARow3 = 0;
//
//        int startingIteratorPoint = 0;
//
//        int lastIteratorPoint = inputedWord.length() - 1;
//
//        OuterLoop:
//        for (int i = 0; i < inputedWord.length(); i++) //loops through word
//        {
//
//            String currentCharacterInWord = String.valueOf(inputedWord.charAt(i)); // converts char to string
//
//            String currentCharacterInOtherWord = String.valueOf(otherWord.charAt(i));
//
//            if (currentCharacterInWord.equals(currentCharacterInOtherWord)) {
//                lettersInARow += 1;
//            }
////            InnerLoop:
////            for (int i2 = 0; i < otherWord.length(); i++)
////            {
////                String currentCharacterInOtherWord = String.valueOf(inputedWord.charAt(i2));
////                if (currentCharacterInWord.equals(currentCharacterInOtherWord))
////                {
////                    lettersInARow += 1;
////                }
////                else
////                {
////                    break InnerLoop;
////                }
////            }
//            // return lettersInARow;
//        }
//        return lettersInARow;
//    }

//    public static Map<String, List<String>> breakThreeLetterWordIntoPieces(String word)
//    {
//        Map<String, List<String>> wordFragments = new HashMap<>();
//        List<String> listOfFragments = new ArrayList<>();
//        String wordFragment =
//                String.valueOf(word.charAt(0)) +
//                String.valueOf(word.charAt(1));
//
//        String wordFragment2 =
//                String.valueOf(word.charAt(1)) +
//                String.valueOf(word.charAt(2));
//
//        listOfFragments.add(wordFragment);
//        listOfFragments.add(wordFragment2);
//
//        wordFragments.put(word,listOfFragments);
//
//        return wordFragments;
//
////        for (int i = 0; i < word.length(); i++)
////        {
////            String currentCharacterInWord = String.valueOf(word.charAt(i)); // converts char to string
////
////            wordFragment =
////
////        }
//
//
//
//    }


    //So far, I think the next step is to work on this function, the process seems straight forward.
    //I only hard coded it to 3 just in case and for a good starting point.


    public static List<String> breakWordIntoPiecesFromRightToLeft(String word)
    {

        int sizeOfWord = word.length();
        List<String> fragments = new ArrayList<>();

        for (int i = 0; i < word.length() - 1; i++)
        {
             String aFragment = removeLastChar(word, i);
             fragments.add(aFragment);
        }
//        for (String fragment : fragments)
//        {
//            System.out.println("\n" + fragment);
//        }
        return fragments;
    }

    public static List<String> breakWordIntoPiecesFromLeftToRight(String word)
    {

        int sizeOfWord = word.length();
        List<String> fragments = new ArrayList<>();

        for (int i = sizeOfWord - 1; i >= 1; i--)
        {
            String aFragment = removeFirstChar(word, i);
            if (aFragment.length() > 1)
            {
                fragments.add(aFragment);
            }
        }
//        for (String fragment : fragments)
//        {
//            System.out.println("\n" + fragment);
//        }
        return fragments;
    }

    private static String removeLastChar(String str, Integer i)

    {
        return str.substring(0, str.length() - i); // remove last - letters
    }

    public static String removeFirstChar(String s, Integer i)
    {
        return s.substring(i); // remove first i letters
    }


    public static List<String> breakThreeLetterWordIntoPieces(String word)
    {
        List<String> listOfFragments = new ArrayList<>();
        String wordFragment =
                String.valueOf(word.charAt(0)) +
                String.valueOf(word.charAt(1));

        String wordFragment2 =
                String.valueOf(word.charAt(1)) +
                String.valueOf(word.charAt(2));

        listOfFragments.add(wordFragment);
        listOfFragments.add(wordFragment2);

        return listOfFragments;

//        for (int i = 0; i < word.length(); i++)
//        {
//            String currentCharacterInWord = String.valueOf(word.charAt(i)); // converts char to string
//
//            wordFragment =
//
//        }
    }

    public static void spellCheck3LetterWord(String inputedWord)
    {
        List<Recipe> listOfExistingRecipes = getAllObjects.allCurrentRecipes();
        List<String> listOfNamesOfExistingRecipes = organizeData.listOfNamesOfAllRecipes(listOfExistingRecipes);

        List<String> listOfFragmentsOfInputedWord = breakThreeLetterWordIntoPieces(inputedWord);

        for (int i = 0; i<listOfFragmentsOfInputedWord.size(); i ++)
        {
            String currentFragment = listOfFragmentsOfInputedWord.get(i);
            for (String name : listOfNamesOfExistingRecipes)
            {
                List<String> fragmentsOfName = breakThreeLetterWordIntoPieces(name);
                Boolean matchFound = fragmentsOfName.contains(currentFragment);
                if (matchFound)
                {
                    System.out.println("\nDid you mean: " + name);
                }
            }
        }
    }

    public static void breakWordIntoPiecesRefactored(String str)
    {
        int subtractCharactersBy = 0;
        int lengthOfWord = str.length();
        while (lengthOfWord > 1) //this if can be checked as the method is called
        {

            str = removeFirstChar(str, subtractCharactersBy); // this is choking on "i = 2"
            lengthOfWord -= 1;
            subtractCharactersBy +=1;
            List<String> fragments = breakWordIntoPiecesFromRightToLeft(str);

            for (String fragment : fragments)
            {
                System.out.print("\n" + fragment);
            }
        }
    }

    public static void breakWordIntoPieces(String str)
    {



        if (str.length() > 1)
        {

            List<String> fragments = breakWordIntoPiecesFromRightToLeft(str);

            for (String fragment : fragments)
            {
                System.out.print("\n" + fragment);
            }
        }
        System.out.print("\n");

        str = removeFirstChar(str, 1);
        List<String> fragments2 = breakWordIntoPiecesFromRightToLeft(str);

        for (String fragment : fragments2)
        {
            System.out.print("\n" + fragment);
        }

        if (str.length() > 1)
        {
            str = removeFirstChar(str, 1);
            List<String> fragments3 = breakWordIntoPiecesFromRightToLeft(str);

            System.out.print("\n");

            for (String fragment : fragments3)
            {
                System.out.print("\n" + fragment);
            }
        }

        if (str.length() > 1)
        {
            str = removeFirstChar(str, 1);
            List<String> fragments4 = breakWordIntoPiecesFromRightToLeft(str);

            System.out.print("\n");

            for (String fragment : fragments4)
            {
                System.out.print("\n" + fragment);
            }
        }

        if (str.length() > 1) {

            str = removeFirstChar(str, 1);
            List<String> fragments5 = breakWordIntoPiecesFromRightToLeft(str);

            System.out.print("\n");

            for (String fragment : fragments5)
            {
                System.out.print("\n" + fragment);
            }
        }


        if (str.length() > 1)
        {
            str = removeFirstChar(str, 1);
            List<String> fragments6 = breakWordIntoPiecesFromRightToLeft(str);

            System.out.print("\n");

            for (String fragment : fragments6)
            {
                System.out.print("\n" + fragment);
            }
        }

        if (str.length() > 1)
        {
            str = removeFirstChar(str, 1);
            List<String> fragments7 = breakWordIntoPiecesFromRightToLeft(str);
            System.out.print("\n");
            for (String fragment : fragments7)
            {
                System.out.print("\n" + fragment);
            }
        }

        if (str.length() > 1)
        {
            str = removeFirstChar(str, 1);
            List<String> fragments8 = breakWordIntoPiecesFromRightToLeft(str);

            System.out.print("\n");

            for (String fragment : fragments8)
            {
                System.out.print("\n" + fragment);
            }
        }
    }

    public static List<List<String>> substrings(String input) {

        // Base case: There's only one way to split up a single character
        // string, and that is ["x"] where x is the character.
        if (input.length() == 1){
            return Collections.singletonList(Collections.singletonList(input));
        }
        // To hold the result
        List<List<String>> result = new ArrayList<>();

        // Recurse (since you tagged the question with recursion ;)
        for (List<String> subresult : substrings(input.substring(1))) {

            // Case: Don't split
            List<String> l2 = new ArrayList<>(subresult);
            l2.set(0, input.charAt(0) + l2.get(0));
            result.add(l2);

            // Case: Split
            List<String> l = new ArrayList<>(subresult);
            l.add(0, input.substring(0, 1));
            result.add(l);
        }

        return result;
    }

}
