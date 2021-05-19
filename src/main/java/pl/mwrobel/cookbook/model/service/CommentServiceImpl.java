package pl.mwrobel.cookbook.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwrobel.cookbook.exception.CommentNotFoundException;
import pl.mwrobel.cookbook.exception.RecipeNotFoundException;
import pl.mwrobel.cookbook.model.Comment;
import pl.mwrobel.cookbook.model.Recipe;
import pl.mwrobel.cookbook.repository.CommentRepository;
import pl.mwrobel.cookbook.repository.RecipeRepository;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService{

    private final RecipeRepository recipeRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(RecipeRepository recipeRepository, CommentRepository commentRepository) {
        this.recipeRepository = recipeRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(()-> new CommentNotFoundException("Comment by id " + id + " was not found"));

    }

    @Override
    public Comment addComment(Comment comment, Long recipeId) {
        Recipe commentedRecipe = this.recipeRepository
                .findById(recipeId).orElseThrow(() -> new RecipeNotFoundException("Recipe by id " + recipeId + " was not found"));
        comment.setTimestamp(LocalDateTime.now());
        commentedRecipe.addComment(comment);
        this.recipeRepository.save(commentedRecipe);
        return comment;
    }
}
