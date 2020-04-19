package com.company.Controllers.Database;

import com.company.Main;
import com.company.Models.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.company.Controllers.SpellCheck.breakThreeLetterWordIntoPieces;

public class getAllObjects
{

    public static List<Recipe> allCurrentRecipes()
    {


//        Recipe cereal = new Recipe();
//        cereal.setNameOfRecipe("cereal");
//        List<String> cerealIngredients = new ArrayList<>();
//        cerealIngredients.add("cereal");
//        cerealIngredients.add("milk");
//        cereal.setIngredients(cerealIngredients);
//        cereal.setLetterCountsOfNameOfRecipe(Main.getLetterCountsOfWord(cereal.getNameOfRecipe()));
//
//
//
//        Recipe sandwich = new Recipe();
//        sandwich.setNameOfRecipe("sandwich");
//        List<String> sandwichIngredients = new ArrayList<>();
//        sandwichIngredients.add("bread");
//        sandwichIngredients.add("ham");
//        sandwichIngredients.add("cheese");
//        sandwichIngredients.add("mayonnaise");
//        sandwichIngredients.add("mustard");
//        sandwich.setIngredients(sandwichIngredients);
//        sandwich.setLetterCountsOfNameOfRecipe(Main.getLetterCountsOfWord(sandwich.getNameOfRecipe()));

        Recipe tea = new Recipe();
        tea.setNameOfRecipe("tea");
        tea.setListOfWordFragments(breakThreeLetterWordIntoPieces(tea.getNameOfRecipe()));
      //  Map<String, List<String>> fragmentsOfTea = new HashMap<>();
      //  fragmentsOfTea.putAll(Main.breakThreeLetterWordIntoPieces(tea.getNameOfRecipe()));
     //   tea.setFragmenstsOfName(fragmentsOfTea);




        Recipe rea = new Recipe();
        rea.setNameOfRecipe("rea");
       // Map<String, List<String>> fragmentsOfRea = new HashMap<>();
        //fragmentsOfRea.putAll(Main.breakThreeLetterWordIntoPieces(rea.getNameOfRecipe()));
      //  rea.setFragmenstsOfName(fragmentsOfRea);
        rea.setListOfWordFragments(breakThreeLetterWordIntoPieces(rea.getNameOfRecipe()));

        Recipe sea = new Recipe();
        sea.setNameOfRecipe("sea");
        sea.setListOfWordFragments(breakThreeLetterWordIntoPieces(sea.getNameOfRecipe()));




        List<Recipe> listOfRecipes = new ArrayList<>();
//        listOfRecipes.add(cereal);
//        listOfRecipes.add(sandwich);
        listOfRecipes.add(tea);
        listOfRecipes.add(rea);
        listOfRecipes.add(sea);




        return listOfRecipes;

    }




}
