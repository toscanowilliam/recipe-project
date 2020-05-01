package com.company;
import com.company.Controllers.Database.getAllObjects;
import com.company.Controllers.Database.organizeData;

import com.company.Models.Recipe;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.company.Controllers.SpellCheck.*;


public class Main
{
    public static void main(String[] args)
    {
        //promptUser();
        String inputedWord = "ABIGWORD";

        //test spellCheck
//        for (String str: spellCheck(inputedWord))
//        {
//            System.out.print("\n" + str);
//        }

        //test replaceVowels()
        //replaceVowels(inputedWord);

        //test breakStringIntoAllPossibleSubstrings()
//        for (String str : breakStringIntoAllPossibleSubstrings(inputedWord, 3, 5))
//        {
//            System.out.print("\n" + str);
//
//        }

        //test separateChars
        //replaceVowels(inputedWord.toLowerCase());

        //test replaceVowelsWithBlank
        replaceVowelsWithBlank(inputedWord);

    }

    public static void promptUser()
    {
        //User input and output
        //This whole function was helped by:
        //https://stackoverflow.com/questions/34928182/how-to-make-a-java-main-menu-loop-after-using-a-case

        Boolean inputIsCorrect = true;

        while (inputIsCorrect)
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

                default:
                    System.out.println("\nThis is not a valid Menu Option! Please Select Another");
                    break;
            }
        }
    }

    public static void findByRecipe()
    {
        Boolean userChoseReturnToMainMenu = false;

        whileLoop:
        while (!userChoseReturnToMainMenu) {

            Boolean foundRecipe = false;

            //TODO: Use numbers instead of letters in a toString fashion
            //TODO: Refactor into userPrompt Method or a separate Method
            System.out.print("\nPlease enter a Recipe\n");
            System.out.print("Press r/R to return to Main Menu\n");
            System.out.print("Press q/Q to Quit\n");

            Scanner input = new Scanner(System.in);
            String selectionOrRecipe = input.next();

            for (Recipe recipe : getAllObjects.allCurrentRecipes())
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
            }
            if (!foundRecipe)
            {
                System.out.print("\nRecipe not found. Please check your spelling and try again");
            }
        }
    }
}
