package com.company.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {

    private int id;

    private String nameOfRecipe;

    private List<String> ingredients;

    private Map<String, Integer> letterCountsOfNameOfRecipe;

  //  private Map<String, List<String>> fragmenstsOfName = new HashMap<>();

    private List<String> listOfWordFragments = new ArrayList<>();


    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public String getNameOfRecipe() { return nameOfRecipe; }

    public void setNameOfRecipe(String nameOfRecipe) { this.nameOfRecipe = nameOfRecipe; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Map<String, Integer> getLetterCountsOfNameOfRecipe() { return letterCountsOfNameOfRecipe; }

    public void setLetterCountsOfNameOfRecipe(Map<String, Integer> letterCountsOfNameOfRecipe) { this.letterCountsOfNameOfRecipe = letterCountsOfNameOfRecipe; }
//
//    public Map<String, List<String>> getFragmenstsOfName() { return fragmenstsOfName; }
//
//    public void setFragmenstsOfName(Map<String, List<String>> fragmenstsOfName) { this.fragmenstsOfName = fragmenstsOfName; }


    public List<String> getListOfWordFragments() { return listOfWordFragments; }

    public void setListOfWordFragments(List<String> listOfWordFragments) { this.listOfWordFragments = listOfWordFragments; }

}
