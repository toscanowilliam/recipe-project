package com.company.Controllers;

import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Recipe> allCurrentRecipes(){


        Recipe cereal = new Recipe();
        cereal.setNameOfRecipe("cereal");
        List<String> cerealIngredients = new ArrayList<>();
        cerealIngredients.add("cereal");
        cerealIngredients.add("milk");
        cereal.setIngredients(cerealIngredients);

        Recipe sandwich = new Recipe();
        sandwich.setNameOfRecipe("sandwich");
        List<String> sandwichIngredients = new ArrayList<>();
        sandwichIngredients.add("bread");
        sandwichIngredients.add("ham");
        sandwichIngredients.add("cheese");
        sandwichIngredients.add("mayonnaise");
        sandwichIngredients.add("mustard");
        sandwich.setIngredients(sandwichIngredients);

        List<Recipe> listOfRecipes = new ArrayList<>();
        listOfRecipes.add(cereal);
        listOfRecipes.add(sandwich);

        return listOfRecipes;














    }


}
