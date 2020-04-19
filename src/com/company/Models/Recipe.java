package com.company.Models;

import java.util.List;
import java.util.Map;

public class Recipe {

    private int id;

    private String nameOfRecipe;

    private List<String> ingredients;

    private Map<String, Integer> letterCountsOfNameOfReipe;


    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public String getNameOfRecipe() { return nameOfRecipe; }

    public void setNameOfRecipe(String nameOfRecipe) { this.nameOfRecipe = nameOfRecipe; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Map<String, Integer> getLetterCountsOfNameOfReipe() { return letterCountsOfNameOfReipe; }

    public void setLetterCountsOfNameOfReipe(Map<String, Integer> letterCountsOfNameOfReipe) { this.letterCountsOfNameOfReipe = letterCountsOfNameOfReipe; }


}
