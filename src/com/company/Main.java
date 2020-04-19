package com.company;
import com.company.Controllers.Recipes;
import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here


        //User input and output
        System.out.println("Type in an recipe to list all the ingredients within that recipe.");
        Scanner input = new Scanner(System.in);
        String recipeInput = input.next();
        for (Recipe recipe : Recipes.allCurrentRecipes())
        {
            if (recipe.getNameOfRecipe().equals(recipeInput))
            {
                for (String ingredient : recipe.getIngredients())
                {
                    System.out.print(ingredient);
                    System.out.print("\n");
                }
            }
        }

    }
}
