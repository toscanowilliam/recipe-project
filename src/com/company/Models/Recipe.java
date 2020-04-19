package com.company.Models;

import java.util.List;

public class Recipe {



    private String nameOfRecipe;

    private List<String> ingredients;

    public List<String> getIngredients() { return ingredients; }

    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public String getNameOfRecipe() { return nameOfRecipe; }

    public void setNameOfRecipe(String nameOfRecipe) { this.nameOfRecipe = nameOfRecipe; }


}
