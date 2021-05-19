package pl.mwrobel.cookbook.model.service;

import pl.mwrobel.cookbook.model.Recipe;

import java.util.List;


public interface RecipeService {

    public Recipe addRecipe(Recipe recipe);

    public List<Recipe> findAllRecipes();

    public Recipe updateRecipe(Recipe employee);

    public Recipe findRecipeById(Long id);

    public void deleteRecipe(Long id);

    Recipe rateRecipe(Long id, Integer rating);
}
