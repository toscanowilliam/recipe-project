package com.company.Controllers;

import com.company.Controllers.Database.getAllObjects;
import com.company.Controllers.Database.organizeData;
import com.company.Models.Recipe;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.Controllers.Database.getAllObjects.allCurrentRecipes;
import static com.company.Controllers.Database.organizeData.listOfNamesOfAllRecipes;

public class SpellCheck {

    //This function will most likely not be needed any more. It maps each character with a word count. Could be useful but I don;t know
    public static void compareTheNumberOfLettersOfWord(String inputedWord) {

        Map<String, Integer> letterCountsOfInputedWord = getLetterCountsOfWord(inputedWord);

        OuterLoop:
        for (Recipe recipe : allCurrentRecipes()) {
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
    public static Map<String, Integer> getLetterCountsOfWord(String inputedWord)
    {
        String word = inputedWord;

        Map<String, Integer> numberOfCharactersInWord = new HashMap<>();

        for (int i = 0; i < word.length(); i++) //loops through word
        {
            String characterInWord = String.valueOf(word.charAt(i)); // converts char to string
            int letterCount = word.length() - word.replaceAll(characterInWord, "").length();

            numberOfCharactersInWord.put(characterInWord, letterCount);
        }
        return numberOfCharactersInWord;
    }


//Leaving this commented just in case. Could come in handy but will most likely just use the substring()
//    private static String removeLastChar(String str, Integer i)
//
//    {
//        return str.substring(0, str.length() - i); // remove last - letters
//    }
//
//    public static String removeFirstChar(String s, Integer i)
//    {
//        return s.substring(i); // remove first i letters
//    }

//Leaving this commented for future reference.
//    public static void spellCheck3LetterWord(String inputedWord)
//    {
//        List<Recipe> listOfExistingRecipes = getAllObjects.allCurrentRecipes();
//        List<String> listOfNamesOfExistingRecipes = organizeData.listOfNamesOfAllRecipes(listOfExistingRecipes);
//
//        List<String> listOfFragmentsOfInputedWord = breakThreeLetterWordIntoPieces(inputedWord);
//
//        for (int i = 0; i<listOfFragmentsOfInputedWord.size(); i ++)
//        {
//            String currentFragment = listOfFragmentsOfInputedWord.get(i);
//            for (String name : listOfNamesOfExistingRecipes)
//            {
//                List<String> fragmentsOfName = breakThreeLetterWordIntoPieces(name);
//                Boolean matchFound = fragmentsOfName.contains(currentFragment);
//                if (matchFound)
//                {
//                    System.out.println("\nDid you mean: " + name);
//                }
//            }
//        }
//    }

//    From: https://stackoverflow.com/questions/61332162/print-all-the-combination-of-substrings-from-a-given-string-in-order-by-letter
    public static List<String> breakStringIntoAllPossibleSubstrings(String str, int num)
    {
        List<String> listOfSubstrings = new ArrayList<>();
        Boolean insideLoop = false;

        for(int i=0; i<=str.length()-num; i++)
        {
            for(int j=str.length(); j>=i+num; j--)
            {
                //System.out.println(str.substring(i, j));
                if (insideLoop) //This is simply to not add the complete string to the list. Only substrings
                {
                    listOfSubstrings.add(str.substring(i, j));
                }
                insideLoop = true;
            }
        }
        return listOfSubstrings;
    }

    public static List<String> spellCheck(String inputedWord)
    {
        List<String> listOfSubstringsForInputedWord = breakStringIntoAllPossibleSubstrings(inputedWord, 2);
        List<String> listOfWordsUserMightHaveMeant = new ArrayList<>();

        for (Recipe recipe : allCurrentRecipes())
        {
            List<String> listOfSubstringsForCurrentRecipe = recipe.getListOfSubstrings();

            for (String substring : listOfSubstringsForCurrentRecipe)
            {
                if (listOfSubstringsForInputedWord.contains(substring) && !listOfWordsUserMightHaveMeant.contains(recipe.getNameOfRecipe()))
                {
                    listOfWordsUserMightHaveMeant.add(recipe.getNameOfRecipe());
                }
            }
        }
        return listOfWordsUserMightHaveMeant;
    }
}
