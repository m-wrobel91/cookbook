package pl.mwrobel.cookbook.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwrobel.cookbook.exception.RecipeNotFoundException;
import pl.mwrobel.cookbook.model.Comment;
import pl.mwrobel.cookbook.model.Recipe;
import pl.mwrobel.cookbook.repository.CommentRepository;
import pl.mwrobel.cookbook.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, CommentRepository commentRepository) {
        this.recipeRepository = recipeRepository;
        this.commentRepository = commentRepository;
    }
    @Override
    public Recipe addRecipe(Recipe recipe){
        //employee.setEmployeeCode(UUID.randomUUID().toString());
        if(recipe.getImageUrl() == null){
            recipe.setImageUrl("assets/img/no-image.png");
        }
        return recipeRepository.save(recipe);
    }
    @Override
    public List<Recipe> findAllRecipes(){
        return recipeRepository.findAll();
    }
    @Override
    public Recipe updateRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }
    @Override
    public Recipe findRecipeById(Long id){
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe by id " + id + " was not found"));
    }
    @Override
    public void deleteRecipe(Long id){
        Recipe recipeToBeDeleted = recipeRepository.findById(id).get();
        recipeToBeDeleted.getComments().forEach(commentRepository::delete);
        recipeRepository.delete(recipeToBeDeleted);
    }

    @Override
    public Recipe rateRecipe(Long id, Integer rating) {

        Recipe ratedRecipe = recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("Recipe by id " + id + " was not found"));
        ratedRecipe.updateRating(rating);
        recipeRepository.save(ratedRecipe);
        return ratedRecipe;
    }
}
