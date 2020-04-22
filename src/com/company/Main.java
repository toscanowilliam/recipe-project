package com.company;
import com.company.Controllers.Database;
import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        promptUser();
    }

    public static void promptUser()
    {
        //User input and output
        //This whole function was helped by:
        //https://stackoverflow.com/questions/34928182/how-to-make-a-java-main-menu-loop-after-using-a-case

        /*
            Selection:
            Q/q == Quit
            B/b == Back
            M/m == Main Menu
            R/r == Enter Recipe
            I/i == Enter Ingredient
         */

        Boolean inputIsCorrect = true;

        String stringSelection = "";

        while(!stringSelection.equals("q"))
        {
            System.out.println("\nPlease Select the following:\n");
            System.out.println("Find ingredients by recipe? (Press I/i)\n");
            System.out.println("Find recipe by ingredients? (Press R/r)\n");
            System.out.println("Quit? (Press Q/q)\n");

            Scanner selection = new Scanner(System.in);
            stringSelection = selection.next().toLowerCase();

            switch (stringSelection)
            {
                case "i":
                    findByRecipe();
                    continue;

                case "q":
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
        String selectionOrRecipe = "";

        whileLoop:
        while(!selectionOrRecipe.equals("m"))
        {
            Boolean foundRecipe = false;

            System.out.print("\nPlease enter a Recipe\n");
            System.out.print("Press m/M to return to Main Menu\n");
            System.out.print("Press q/Q to Quit\n");

            Scanner input = new Scanner(System.in);
            selectionOrRecipe = input.next().toLowerCase();

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
                else if (selectionOrRecipe.equals("q"))
                {
                    System.out.println("\nExiting Program...");
                    System.exit(0);
                    break;
                }
                else if (selectionOrRecipe.equals("m"))
                {
                    System.out.println("\nBack to Main Menu");
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
