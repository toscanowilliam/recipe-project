package com.company.Controllers;

import com.company.Controllers.Database.getAllObjects;
import com.company.Controllers.Database.organizeData;
import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellCheck {

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

    public static Map<String, Integer> getLetterCountsOfWord(String inputedWord) {

        String word = inputedWord;

        Map<String, Integer> numberOfCharactersInWord = new HashMap<>();
//        Map<Character, Integer> numberOfCharactersInWord = new HashMap<>();


        for (int i = 0; i < word.length(); i++) //loops through word
        {

            String characterInWord = String.valueOf(word.charAt(i)); // converts char to string
            int letterCount = word.length() - word.replaceAll(characterInWord, "").length();

            numberOfCharactersInWord.put(characterInWord, letterCount);
        }

        return numberOfCharactersInWord;
    }

    public static int checkHowManyLettersInARowMatch(String inputedWord, String otherWord) {

        //This function works but only if the letters are in matching order and the words are the same size.
        //In other words, too many things are hard-coded here.

        //      Map<String, Integer> numberOfCharactersInWord = new HashMap<>();
//        Map<Character, Integer> numberOfCharactersInWord = new HashMap<>();

        int lettersInARow = 0;

        int lettersInARow2 = 0;

        int lettersInARow3 = 0;

        int startingIteratorPoint = 0;

        int lastIteratorPoint = inputedWord.length() - 1;

        OuterLoop:
        for (int i = 0; i < inputedWord.length(); i++) //loops through word
        {

            String currentCharacterInWord = String.valueOf(inputedWord.charAt(i)); // converts char to string

            String currentCharacterInOtherWord = String.valueOf(otherWord.charAt(i));

            if (currentCharacterInWord.equals(currentCharacterInOtherWord)) {
                lettersInARow += 1;
            }
//            InnerLoop:
//            for (int i2 = 0; i < otherWord.length(); i++)
//            {
//                String currentCharacterInOtherWord = String.valueOf(inputedWord.charAt(i2));
//                if (currentCharacterInWord.equals(currentCharacterInOtherWord))
//                {
//                    lettersInARow += 1;
//                }
//                else
//                {
//                    break InnerLoop;
//                }
//            }
            // return lettersInARow;
        }
        return lettersInARow;
    }

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
}
