package com.company.Controllers.Database;

import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class organizeData
{
    public static List<String> listOfNamesOfAllRecipes (List<Recipe> listOfExistingRecipes)
    {
        List<String> listOfNamesOfExistingRecipes = new ArrayList<>();

        for (Recipe recipe: listOfExistingRecipes)
        {
            String name = recipe.getNameOfRecipe();
            listOfNamesOfExistingRecipes.add(name);
        }
        return listOfNamesOfExistingRecipes;
    }
}
