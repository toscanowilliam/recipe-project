package com.company;
import com.company.Controllers.Database;
import com.company.Models.Recipe;

import java.util.*;


public class Main {

    public static void main(String[] args)
    {
	    // write your code here

        spellCheck("sandwich");

        //promptUser();


    }

    public static void promptUser()
    {
        //User input and output
        //This whole function was helped by:
        //https://stackoverflow.com/questions/34928182/how-to-make-a-java-main-menu-loop-after-using-a-case

        Boolean inputIsCorrect = true;

        while(inputIsCorrect)
        {
            System.out.println("\nPlease Select the following:\n");
            System.out.println("Find ingredients by recipe? (Press 1)\n");
            System.out.println("Find recipe by ingredients? (Press 2)\n");
            System.out.println("Quit? (Press 3)\n");

            Scanner selection = new Scanner(System.in);
            int numberedSelection = selection.nextInt();

            switch (numberedSelection)
            {
                case 1:
                    findByRecipe();
                    continue;
                case 3:

                    System.out.println("\nExiting Program...");
                    System.exit(0);
                    break;

                default :
                    System.out.println("\nThis is not a valid Menu Option! Please Select Another");
                    break;
            }
        }
    }

    public static void findByRecipe()
    {

        Boolean userChoseReturnToMainMenu = false;

        whileLoop:
        while(!userChoseReturnToMainMenu)
        {

            Boolean foundRecipe = false;

            //TODO: Use numbers instead of letters in a toString fashion
            System.out.print("\nPlease enter a Recipe\n");
            System.out.print("Press r/R to return to Main Menu\n");
            System.out.print("Press q/Q to Quit\n");

            Scanner input = new Scanner(System.in);
            String selectionOrRecipe = input.next();

            for (Recipe recipe : Database.allCurrentRecipes())
            {
                if (recipe.getNameOfRecipe().equals(selectionOrRecipe))
                {
                    foundRecipe = true;
                    for (String ingredient : recipe.getIngredients())
                    {
                        System.out.print(ingredient);
                        System.out.print("\n");
                    }
                    break;
                }
                else if (selectionOrRecipe.equals("Q".toLowerCase()))
                {
                    System.out.println("\nExiting Program...");
                    System.exit(0);
                    break;
                }
                else if (selectionOrRecipe.equals("R".toLowerCase()))
                {
                    break whileLoop;
                }
                else
                {

                }
            }
            if (!foundRecipe)
            {
                System.out.print("\nRecipe not found. Please check your spelling and try again");
            }
        }


    }


    public static void spellCheck(String inputedWord)
    {

        Map<String, Integer> letterCountsOfInputedWord = letterCountsOfWord(inputedWord);


        OuterLoop:
        for (Recipe recipe : Database.allCurrentRecipes())
        {
            String currentNameOfRecipe = recipe.getNameOfRecipe();
            Map<String, Integer> letterCountsOfNameOfRecipe = letterCountsOfWord(currentNameOfRecipe);

            //I'm trying to find out how to check if there's 1 matching key (letter) in both maps.
            //Then, I'm trying to see if there is a value (letter count) greater than 1 in at least one of the maps.

            System.out.print("\n1");

            InnerLoop:
            for (Map.Entry<String, Integer> entry : letterCountsOfNameOfRecipe.entrySet())
            {
                System.out.print("\n2");

                String currentLetterOfRecipe = entry.getKey();
                int currentLetterCountOfRecipe = entry.getValue();

                if (letterCountsOfInputedWord.containsKey(currentLetterOfRecipe)) //If there is a matching letter in both words
                {
                    System.out.print("\n3");

                    if (currentLetterCountOfRecipe == 2 && letterCountsOfInputedWord.get(currentLetterOfRecipe) == 2)
                    {
                        System.out.print("\nDid you mean " + currentNameOfRecipe + "?\n");
                        break OuterLoop;
                    }
                }
            }
            System.out.print("\nRecipe not found. Please check your spelling and try again");
        }
    }

    public static Map<String, Integer> letterCountsOfWord(String inputedWord)
    {

        String word = inputedWord;

        Map<String, Integer> numberOfCharactersInWord = new HashMap<>();
//        Map<Character, Integer> numberOfCharactersInWord = new HashMap<>();


        for (int i = 0; i < word.length(); i++) //loops through word
        {

            String characterInWord = String.valueOf(word.charAt(i)); // converts char to string
            int letterCount = word.length() - word.replaceAll(characterInWord,"").length();

            numberOfCharactersInWord.put(characterInWord, letterCount);
        }

        return numberOfCharactersInWord;
    }


}
