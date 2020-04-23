package com.company.Controllers.Database;

import com.company.Controllers.SpellCheck;
import com.company.Main;
import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class getAllObjects
{

    public static List<Recipe> allCurrentRecipes()
    {


        Recipe cereal = new Recipe();
        cereal.setNameOfRecipe("cereal");
        List<String> cerealIngredients = new ArrayList<>();
        cerealIngredients.add("cereal");
        cerealIngredients.add("milk");
        cereal.setIngredients(cerealIngredients);
        cereal.setLetterCountsOfNameOfRecipe(SpellCheck.getLetterCountsOfWord(cereal.getNameOfRecipe()));
        cereal.setListOfSubstrings(SpellCheck.breakStringIntoAllPossibleSubstrings(cereal.getNameOfRecipe(), 2, cereal.getNameOfRecipe().length()));

        Recipe sandwich = new Recipe();
        sandwich.setNameOfRecipe("sandwich");
        List<String> sandwichIngredients = new ArrayList<>();
        sandwichIngredients.add("bread");
        sandwichIngredients.add("ham");
        sandwichIngredients.add("cheese");
        sandwichIngredients.add("mayonnaise");
        sandwichIngredients.add("mustard");
        sandwich.setIngredients(sandwichIngredients);
        sandwich.setLetterCountsOfNameOfRecipe(SpellCheck.getLetterCountsOfWord(sandwich.getNameOfRecipe()));
        sandwich.setListOfSubstrings(SpellCheck.breakStringIntoAllPossibleSubstrings(sandwich.getNameOfRecipe(), 2, sandwich.getNameOfRecipe().length()));

        List<Recipe> listOfRecipes = new ArrayList<>();
        listOfRecipes.add(cereal);
        listOfRecipes.add(sandwich);



        return listOfRecipes;

    }




}
